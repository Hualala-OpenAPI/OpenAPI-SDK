package com.hualala.openapi.sdk.requests.promotion;

import com.hualala.openapi.sdk.beans.request.promotion.QueryUserCouponDetailListBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class QueryUserCouponDetailListRequest extends BaseRequest<QueryUserCouponDetailListBean> {

    public QueryUserCouponDetailListRequest() {
        super("/v2/promotion/getUserCouponDetails");
    }

}
