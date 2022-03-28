package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.UpdateOrderStatusBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class UpdateOrderStatusRequest extends BaseRequest<UpdateOrderStatusBean> {
    public UpdateOrderStatusRequest() {
        this.path = "/order/updateOrderStatus";
    }

}
   
    