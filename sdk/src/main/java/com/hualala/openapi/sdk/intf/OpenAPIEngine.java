package com.hualala.openapi.sdk.intf;

import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.responses.shop.DocBaseInfoResponse;
import com.hualala.openapi.sdk.responses.supplyChain.ExamineVoucherResponse;

public interface OpenAPIEngine {
    //基本档
    DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID);
    //订单
    //账单
    //会员
    //营销
    //供应链
    ExamineVoucherResponse queryExamineVoucher(long groupID, ExamineVoucherBean bean);
}
