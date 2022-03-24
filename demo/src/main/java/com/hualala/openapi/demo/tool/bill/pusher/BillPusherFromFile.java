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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class BillPusherFromFile {
    private static OkHttpClient CLIENT = initClient();
    private static final String WWW_FORM_URLENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    private static final ExecutorService pool = Executors.newFixedThreadPool(30);

    //修改以下参数
    static final long reportDate = 0L;
    //吉祥馄饨
    static final long groupID = 0L;
    static final String PUSH_URL = "" + "/addBillData";
    // end

    static final List<String> filePathList = Arrays.asList();

    public static void main(String[] args) {
        OpenAPIEngine engine = new APIHelper();
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.ONLINE.name());

        System.setProperty(SDKConst.APP_KEY_KEY, "1259");
        System.setProperty(SDKConst.APP_SECRET_KEY, "tYsK2nNV");

        filePathList.forEach(path -> {
            BufferedReader reader = null;
            File file = new File(path);
            try {
                reader = new BufferedReader(new FileReader(file));
                String line;
                while (null != (line = reader.readLine())) {
//                    String[] pair = line.split("\t");
                    String[] pair = line.split("\t");
                    if (2 == pair.length) {
                        pool.execute(() -> {
                            pushBill(engine, Long.parseLong(pair[0]), pair[1]);
                        });
                    }
                }
            } catch (Exception e) {
                log.error("文件读取错误", e);
            }
        });
    }

    private static void pushBill(OpenAPIEngine engine, long shopID, String orderKey) {
        QueryBillDetailResponse response = engine.queryBillDetail(groupID, shopID, reportDate, Collections.singletonList(orderKey));
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
            log.error("获取账单数据出错 {}", response.getMessage());
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

                billList.add(bill);
            } catch (Exception e) {
                log.error("处理账单 {} 异常", o.getString("saasOrderKey"), e);
            }
        }

        return billList;
    }

    private static boolean httpSend(long groupID, String url, String orderKey, String orderBody) {
//        log.info("推送账单[{}] 详情:{}", orderKey, orderBody);
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
