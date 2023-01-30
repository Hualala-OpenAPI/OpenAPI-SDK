package com.hualala.openapi.sdk.requests.bill;

import com.hualala.openapi.sdk.beans.request.bill.QueryBillDetailBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryBillDetailRequest extends BaseRequest<QueryBillDetailBean> {

    public QueryBillDetailRequest() {
        super("/report/getBillShopDayDetailBySaasOrderKey");
    }

}
