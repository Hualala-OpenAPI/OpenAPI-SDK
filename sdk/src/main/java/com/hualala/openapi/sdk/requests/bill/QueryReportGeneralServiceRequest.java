package com.hualala.openapi.sdk.requests.bill;

import com.hualala.openapi.sdk.beans.request.bill.QueryReportGeneralServiceBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryReportGeneralServiceRequest extends BaseRequest<QueryReportGeneralServiceBean> {

    public QueryReportGeneralServiceRequest() {
        this.path = "/report/queryReportGeneralService";
    }

}
