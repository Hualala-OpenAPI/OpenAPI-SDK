package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.QueryTableBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class QueryTableRequest extends BaseRequest<QueryTableBean> {
    public QueryTableRequest() {
        this.path = "/order/queryTableMsg";
    }
}
   
    