package com.hualala.openapi.sdk.helper;

import com.hualala.openapi.sdk.beans.request.DocBaseInfoBean;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.DocBaseInfoRequest;
import com.hualala.openapi.sdk.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class APIHelper implements OpenAPIEngine {

    public String getDocBaseInfo(Long groupID, Long shopID) {
        String response = null;

        DocBaseInfoRequest request = new DocBaseInfoRequest();
        request.setGroupID(groupID);
        request.setShopID(shopID);
        DocBaseInfoBean requestBody = new DocBaseInfoBean();
        requestBody.setGroupID(groupID);
        requestBody.setShopID(shopID);
        request.setRequestBody(requestBody);

        try {
            response = WebUtil.post(request);
        } catch (Exception e) {
            log.error("getDocBaseInfo 异常. groupID: {} shopID: {}", groupID, shopID, e);
        }

        return response;
    }

}
