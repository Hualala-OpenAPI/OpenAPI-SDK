package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.QueryOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class QueryOrderRequest extends BaseRequest<QueryOrderBean> {
    public QueryOrderRequest() {
        this.path = "/order/query";
    }
}
   
    