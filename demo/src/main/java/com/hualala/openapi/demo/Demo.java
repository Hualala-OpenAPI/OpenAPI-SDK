package com.hualala.openapi.demo;

import com.hualala.openapi.sdk.beans.request.DocBaseInfoBean;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.requests.DocBaseInfoRequest;
import com.hualala.openapi.sdk.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] arg) {

        DocBaseInfoRequest request = new DocBaseInfoRequest();
        request.setGroupID(1155L);
        request.setShopID(76068673L);
        DocBaseInfoBean requestBody = new DocBaseInfoBean();
        requestBody.setGroupID(1155L);
        requestBody.setShopID(76068673L);
        request.setRequestBody(requestBody);

        try {
            System.setProperty(SDKConst.ENV_KEY, "DEV");
            System.setProperty(SDKConst.APP_KEY_KEY, "1010");
            System.setProperty(SDKConst.APP_SECRET_KEY, "bRFVbWHQ");

            String response = WebUtil.post(request);
            System.out.println(response);
        } catch (Exception e) {
            log.error("exception", e);
        }
    }
}
