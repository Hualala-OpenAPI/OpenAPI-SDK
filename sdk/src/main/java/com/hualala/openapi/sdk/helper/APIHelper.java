package com.hualala.openapi.sdk.helper;

import com.hualala.openapi.sdk.beans.request.DocBaseInfoBean;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.DocBaseInfoRequest;
import com.hualala.openapi.sdk.responses.DocBaseInfoResponse;
import com.hualala.openapi.sdk.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class APIHelper implements OpenAPIEngine {

    public DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID) {
        DocBaseInfoResponse response = null;

        DocBaseInfoRequest request = new DocBaseInfoRequest();
        request.setGroupID(groupID);
        request.setShopID(shopID);
        DocBaseInfoBean requestBody = new DocBaseInfoBean();
        requestBody.setGroupID(groupID);
        requestBody.setShopID(shopID);
        request.setRequestBody(requestBody);

        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocBaseInfoResponse.class);
        } catch (Exception e) {
            log.error("getDocBaseInfo 异常. groupID: {} shopID: {}", groupID, shopID, e);
        }

        return response;
    }

}
