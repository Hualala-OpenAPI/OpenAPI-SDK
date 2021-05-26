package com.hualala.openapi.demo;

import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.helper.APIHelper;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] arg) {
        testDev();
//        testOnline();
//        testOrderDev();
    }

    private static void testDev() {
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.DEV.name());
        System.setProperty(SDKConst.APP_KEY_KEY, "1010");
        System.setProperty(SDKConst.APP_SECRET_KEY, "bRFVbWHQ");

        OpenAPIEngine engine = new APIHelper();
        System.out.println(JSONObject.toJSONString(engine.getDocBaseInfo(1155L, 76068673L)));
    }

    private static void testOrderDev() {
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.DEV.name());
        System.setProperty(SDKConst.APP_KEY_KEY, "1010");
        System.setProperty(SDKConst.APP_SECRET_KEY, "bRFVbWHQ");

        OpenAPIEngine engine = new APIHelper();
        ThirdOrderRequest request = new ThirdOrderRequest();
        //todo init request
        System.out.println(JSONObject.toJSONString(engine.thirdOrder(request)));
    }

    private static void testOnline() {
        OpenAPIEngine engine = new APIHelper();
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.ONLINE.name());

        System.setProperty(SDKConst.APP_KEY_KEY, "");
        System.setProperty(SDKConst.APP_SECRET_KEY, "");

        ExamineVoucherBean bean = JSONObject.parseObject("", ExamineVoucherBean.class);
        System.out.println(JSONObject.toJSONString(engine.queryExamineVoucher(0L, bean)));
    }
}
