package com.hualala.openapi.demo.tool.bill.pusher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.demo.tool.bill.bean.Bill;
import com.hualala.openapi.demo.tool.bill.bean.BillFood;
import com.hualala.openapi.demo.tool.bill.bean.BillMaster;
import com.hualala.openapi.demo.tool.bill.bean.BillPay;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.helper.APIHelper;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class BillPusher {
    private static OkHttpClient CLIENT = initClient();
    private static final String WWW_FORM_URLENCODED = "application/x-www-form-urlencoded; charset=UTF-8";

    public static void main(String[] args) {
        //修改以下参数
        final long groupID = 0L;
        final long shopID = 0L;
        final long reportDate = 0L;
        final List<String> saasOrderKeyList = Arrays.asList("");

        final String PUSH_URL = "http://XXX:XXXX" + "/addBillData";
        // end

        OpenAPIEngine engine = new APIHelper();

        QueryBillDetailResponse response = engine.queryBillDetail(groupID, shopID, reportDate, saasOrderKeyList);
        if ("000".equals(response.getCode())) {
            if (response.getData().containsKey("billDetail")) {
                List<Bill> billList = detail2List(response);

                billList.forEach(bill -> {
                    if (null == bill.getMaster().getChargeBackFlag()) {
                        String remark = bill.getMaster().getOrderRemark();
                        bill.getMaster().setChargeBackFlag(StringUtils.isNotEmpty(remark) && remark.contains("原POS账单") ? 2 : 0);
                    }
                    //推送
                    httpSend(groupID, PUSH_URL, bill.getMaster().getOrderKey(), JSONObject.toJSONString(bill));
                });
            } else {
                log.error("返回数据中未包含账单详情");
            }
        } else {
            log.error("获取账单数据出错 {}", response);
        }
    }

    private static List<Bill> detail2List(QueryBillDetailResponse response) {
        JSONArray billDetailList = response.getData().getJSONArray("billDetail");
        List<Bill> billList = new ArrayList<>(billDetailList.size());
        for (Object detail : billDetailList) {
            JSONObject o = (JSONObject) detail;
            try {
                Bill bill = new Bill();
                bill.setMaster(o.toJavaObject(BillMaster.class));
                if (o.containsKey("foodDetail")) {
                    bill.setFoodLst(o.getJSONArray("foodDetail").stream()
                        .map(food -> ((JSONObject) food).toJavaObject(BillFood.class))
                        .collect(Collectors.toList()));
                }

                if (o.containsKey("payDetail")) {
                    bill.setPayLst(o.getJSONArray("payDetail").stream()
                        .map(pay -> ((JSONObject) pay).toJavaObject(BillPay.class))
                        .collect(Collectors.toList()));
                }

                log.info("获取到账单 {}", bill.getMaster().getOrderKey());
                billList.add(bill);
            } catch (Exception e) {
                log.error("处理账单 {} 异常", o.getString("saasOrderKey"), e);
            }
        }

        return billList;
    }

    private static boolean httpSend(long groupID, String url, String orderKey, String orderBody) {
        log.info(System.currentTimeMillis() + " 开始推送 " + orderKey);
        RequestBody requestBody = RequestBody.create(String.format("groupID=%d&data=[%s]", groupID, URLEncoder.encode(orderBody)),
            MediaType.parse(WWW_FORM_URLENCODED));

        int retry = 10;
        do {
            try {
                Request request = new Request.Builder().url(url).post(requestBody).build();
                String response = doRequest(orderKey, request);
                JSONObject responseBean = JSONObject.parseObject(response);
                if (!"000".equals(responseBean.getString("code"))) {
                    log.error("推送返回错误 {} {}", orderKey, response);
                    try {
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        //do nothing
                    }
                } else {
                    log.info("推送成功 {}", orderKey);
                    return true;
                }
            } catch (Exception e) {
                log.error("推送异常 {} {}", orderKey, e.getMessage());
            }
            retry--;
        } while (retry > 0);

        return false;
    }

    private static String doRequest(String orderNO, Request okRequest) {
        String result = "";

        Call call = getClient().newCall(okRequest);
        Response response = null;
        try {
            response = call.execute();
            result = response.body().string();
        } catch (Exception e) {
            log.error("账单推送异常 {} {}", orderNO, e.getMessage());
        } finally {
            if (null != response && null != response.body()) {
                response.body().close();
            }
        }

        return result;
    }

    public static OkHttpClient initClient() {
        return new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
    }

    private static OkHttpClient getClient() {
        if (null == CLIENT) {
            CLIENT = initClient();
        }

        return CLIENT;
    }
}
