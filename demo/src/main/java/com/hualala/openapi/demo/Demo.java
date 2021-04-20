package com.hualala.openapi.demo;

import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.helper.APIHelper;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] arg) {
        testDev();
//        testOnline();
    }

    private static void testDev() {
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.DEV.name());
        System.setProperty(SDKConst.APP_KEY_KEY, "1010");
        System.setProperty(SDKConst.APP_SECRET_KEY, "bRFVbWHQ");

        OpenAPIEngine engine = new APIHelper();
        System.out.println(JSONObject.toJSONString(engine.getDocBaseInfo(1155L, 76068673L)));
    }

    private static void testOnline() {
        OpenAPIEngine engine = new APIHelper();
        System.setProperty(SDKConst.ENV_KEY, SDKEnv.ONLINE.name());

        System.setProperty(SDKConst.APP_KEY_KEY, "");
        System.setProperty(SDKConst.APP_SECRET_KEY, "");
        System.out.println(JSONObject.toJSONString(engine.getDocBaseInfo(0L, 0L)));
    }
}
