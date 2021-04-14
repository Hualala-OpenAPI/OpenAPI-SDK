package com.hualala.openapi.demo;

import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.requests.BaseRequest;
import com.hualala.openapi.sdk.utils.WebUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    @Data
    private static class OpenFood {
        private Long groupID;
        private Long shopID;
    }

    public static void main(String[] arg) {

        BaseRequest<OpenFood> request = new BaseRequest();
        request.setPath("/doc/getBaseInfo");
        request.setGroupID(1155L);
        request.setShopID(76068673L);
        OpenFood requestBody = new OpenFood();
        requestBody.setGroupID(1155L);
        requestBody.setShopID(76068673L);
        request.setRequestBody(requestBody);

        try {
            System.setProperty(SDKConst.ENV_KEY, "DEV");
            System.setProperty(SDKConst.APP_KEY_KEY, "1010");
            System.setProperty(SDKConst.APP_SECRET_KEY, "bRFVbWHQ");

            String response = WebUtil.put(request);
            System.out.println(response);
        } catch (Exception e) {
            log.error("exception", e);
        }

        return;
    }
}
