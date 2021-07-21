package com.hualala.openapi.sdk.helper;

import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import com.hualala.openapi.sdk.requests.report.DataUploadRequest;
import com.hualala.openapi.sdk.requests.shop.DocBaseInfoRequest;
import com.hualala.openapi.sdk.requests.supplyChain.ExamineVoucherRequest;
import com.hualala.openapi.sdk.responses.order.ThirdOrderResponse;
import com.hualala.openapi.sdk.responses.report.DataUploadResponse;
import com.hualala.openapi.sdk.responses.shop.DocBaseInfoResponse;
import com.hualala.openapi.sdk.responses.supplyChain.ExamineVoucherResponse;
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

    public ThirdOrderResponse thirdOrder(ThirdOrderRequest request) {
        ThirdOrderResponse response = null;
        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ThirdOrderResponse.class);
        } catch (Exception e) {
            log.error("thirdOrder 异常. {}", request, e);
        }

        return response;
    }

    public ExamineVoucherResponse queryExamineVoucher(long groupID, ExamineVoucherBean bean) {
        ExamineVoucherResponse response = null;
        try {
            ExamineVoucherRequest request = new ExamineVoucherRequest();
            request.setGroupID(groupID);
            request.setRequestBody(bean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ExamineVoucherResponse.class);
        } catch (Exception e) {
            log.error("queryExamineVoucher 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return response;
    }

    public DataUploadResponse dataUpload(long groupID, long shopID, DataUploadBean bean) {
        DataUploadResponse response = null;
        try {
            DataUploadRequest request = new DataUploadRequest();
            request.setGroupID(groupID);
            request.setShopID(shopID);
            request.setRequestBody(bean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DataUploadResponse.class);
        } catch (Exception e) {
            log.error("dataUpload 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return response;
    }

}
