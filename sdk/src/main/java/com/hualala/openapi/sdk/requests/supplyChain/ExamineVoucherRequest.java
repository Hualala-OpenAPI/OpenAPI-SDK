package com.hualala.openapi.sdk.requests.supplyChain;

import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class ExamineVoucherRequest extends BaseRequest<ExamineVoucherBean> {

    public ExamineVoucherRequest() {
        this.path = "/v2/supplyChain/queryExamineVoucher";
    }

}
