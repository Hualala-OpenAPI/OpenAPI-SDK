package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.ReturnFoodBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class ReturnFoodRequest extends BaseRequest<ReturnFoodBean> {
    public ReturnFoodRequest() {
        super("/order/returnFood");
    }

}
   
    