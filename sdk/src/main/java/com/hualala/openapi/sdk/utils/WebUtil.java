package com.hualala.openapi.sdk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.config.DevConfig;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WebUtil {
    private static final OkHttpClient WEB_CLIENT = initClient();
    private static final String HOST = initHost();

    private static OkHttpClient initClient() {
        return new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();
    }

    private static String initHost() {
        String env = DevConfig.getInstance().getEnv();

        if (StringUtils.isNotEmpty(env)) {
            switch (SDKEnv.valueOf(env)) {
                case DEV:
                    return "https://dohko-open-api.hualala.com";
                case ONLINE:
                    return "https://open-api.hualala.com";
                default:
                    log.error("环境变量非法");
            }
        } else {
            log.error("缺少哗啦啦OpenAPI SDK必要的环境变量");
        }

        return null;
    }

    public static <T> String post(BaseRequest<T> request) throws Exception {
        valid(request);

        long timestamp = TimeUtil.getTimestamp();

        JSONObject data = new JSONObject();
        data.put("timestamp", timestamp);
        data.put("appKey", DevConfig.getInstance().getAppKey());
        data.put("appSecret", DevConfig.getInstance().getAppSecret());
        data.put("version", "2.0");
        if (null != request.getRequestBody()) {
            data.put("data", request.getRequestBody());
        }

        String sign = SignUtil.calcSign(JSON.toJSONString(data));
        if (StringUtils.isEmpty(sign)) {
            log.error("签名失败. request: {} devConfig: {}", request, DevConfig.getInstance());
            return null;
        }

        String requestBody = SignUtil.AESEncode(DevConfig.getInstance().getAppSecret(), JSONObject.toJSONString(request.getRequestBody()));
        FormBody.Builder bodyBuilder = new FormBody.Builder()
            .add("timestamp", String.valueOf(timestamp))
            .add("appKey", DevConfig.getInstance().getAppKey())
            .add("version", "2.0")
            .add(SignUtil.SIGNATURE, sign)
            .add("requestBody", requestBody);

        Request.Builder requestBuilder = new Request.Builder()
            .url(HOST + request.getPath())
            .post(bodyBuilder.build());

        requestBuilder.addHeader("traceID", CommonUtil.getTraceID())
            .addHeader("groupID", request.getGroupID().toString());
        if (null != request.getShopID()) {
            requestBuilder.addHeader("shopID", request.getShopID().toString());
        }

        return doRequest(WEB_CLIENT.newCall(requestBuilder.build()));
    }

    private static <T> void valid(BaseRequest<T> request) throws Exception {
        if (StringUtils.isEmpty(HOST) || null == request || !request.valid()) {
            throw new Exception("参数非法");
        }
    }

    private static String doRequest(Call call) {
        String result = "{}";

        Response okResponse = null;
        try {
            okResponse = call.execute();
            result = okResponse.body().string();
        } catch (Exception e) {
            log.error("OPENAPI请求失败: " + JSON.toJSONString(call.request()), e);
        } finally {
            if (null != okResponse && null != okResponse.body()) {
                okResponse.body().close();
            }
        }

        return result;
    }
}
