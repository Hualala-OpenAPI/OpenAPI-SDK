package com.hualala.openapi.sdk.requests.deliver;

import com.hualala.openapi.sdk.beans.request.order.ThirdOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DistribOrderInfoRequest extends BaseRequest<ThirdOrderBean> {

    public DistribOrderInfoRequest() {
        super("/manage/distribOrderInfo");
    }

}
