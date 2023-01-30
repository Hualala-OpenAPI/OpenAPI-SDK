package com.hualala.openapi.sdk.requests.equityAccount;

import com.hualala.openapi.sdk.beans.request.equityAccount.QueryProductItemsBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryProductItemsRequest extends BaseRequest<QueryProductItemsBean> {

    public QueryProductItemsRequest() {
        super("/v2/equityaccount/queryProductItemsByProductCategory");
    }

}
