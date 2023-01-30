package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.AddItemBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class AddItemRequest extends BaseRequest<AddItemBean> {
    public AddItemRequest() {
        super("/order/addItems");
    }
}
   
    