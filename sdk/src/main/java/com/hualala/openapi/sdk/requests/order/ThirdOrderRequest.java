package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.ThirdOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class ThirdOrderRequest extends BaseRequest<ThirdOrderBean> {

    public ThirdOrderRequest() {
        this.path = "/order/thirdOrder";
    }

}
