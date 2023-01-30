package com.hualala.openapi.sdk.requests.shop;

import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DocOpenFoodRequest extends BaseRequest<DocBaseInfoBean> {

    public DocOpenFoodRequest() {
        super("/doc/getOpenFood");
    }

}
