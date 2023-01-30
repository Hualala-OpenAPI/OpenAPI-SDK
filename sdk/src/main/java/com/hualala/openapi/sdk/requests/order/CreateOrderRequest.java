package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.CreateOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class CreateOrderRequest extends BaseRequest<CreateOrderBean> {
    public CreateOrderRequest() {
        super("/order/createOrder");
    }
}
   
    