package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.ApplyRefundBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class ApplyRefundRequest extends BaseRequest<ApplyRefundBean> {
    public ApplyRefundRequest() {
        super("/order/applyRefund");
    }
}
   
    