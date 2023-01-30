package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.ThirdOrderBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class SubmitordernewRequest extends BaseRequest<ThirdOrderBean> {
    public SubmitordernewRequest() {
        super("/order/submitordernew");
    }
}
