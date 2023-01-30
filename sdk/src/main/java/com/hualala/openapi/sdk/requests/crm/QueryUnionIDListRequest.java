package com.hualala.openapi.sdk.requests.crm;

import com.hualala.openapi.sdk.beans.request.crm.QueryUnionIDListBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryUnionIDListRequest extends BaseRequest<QueryUnionIDListBean> {

    public QueryUnionIDListRequest() {
        super("/v2/crm/queryUnionIDs");
    }

}
