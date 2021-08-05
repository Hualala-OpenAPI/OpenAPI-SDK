package com.hualala.openapi.sdk.requests.bill;

import com.hualala.openapi.sdk.beans.request.bill.QueryBillDetailByReportDateBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryBillDetailByReportDateRequest extends BaseRequest<QueryBillDetailByReportDateBean> {

    public QueryBillDetailByReportDateRequest() {
        this.path = "/report/getShopBillDetail";
    }

}
