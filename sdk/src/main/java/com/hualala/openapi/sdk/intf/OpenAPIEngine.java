package com.hualala.openapi.sdk.intf;

import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import com.hualala.openapi.sdk.responses.order.ThirdOrderResponse;
import com.hualala.openapi.sdk.responses.report.DataUploadResponse;
import com.hualala.openapi.sdk.responses.shop.DocBaseInfoResponse;
import com.hualala.openapi.sdk.responses.supplyChain.ExamineVoucherResponse;

public interface OpenAPIEngine {
    //基本档
    DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID);

    //订单
    ThirdOrderResponse thirdOrder(ThirdOrderRequest request);

    //账单
    //会员
    //营销
    //供应链
    ExamineVoucherResponse queryExamineVoucher(long groupID, ExamineVoucherBean bean);

    //报表
    DataUploadResponse dataUpload(long groupID, long shopID, DataUploadBean bean);
}
