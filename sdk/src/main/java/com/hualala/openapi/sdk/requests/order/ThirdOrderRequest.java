package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.ThirdOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class ThirdOrderRequest extends BaseRequest<ThirdOrderBean> {

    public ThirdOrderRequest() {
        super("/order/thirdOrder");
    }
}
