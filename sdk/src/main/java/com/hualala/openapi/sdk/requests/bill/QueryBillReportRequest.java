package com.hualala.openapi.sdk.requests.bill;

import com.hualala.openapi.sdk.beans.request.bill.QueryBillReportBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryBillReportRequest extends BaseRequest<QueryBillReportBean> {

    public QueryBillReportRequest() {
        this.path = "/report/queryBillReport";
    }

}
