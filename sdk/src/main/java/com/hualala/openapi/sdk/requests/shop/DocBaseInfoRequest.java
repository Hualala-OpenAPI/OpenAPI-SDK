package com.hualala.openapi.sdk.requests.shop;

import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DocBaseInfoRequest extends BaseRequest<DocBaseInfoBean> {

    public DocBaseInfoRequest() {
        super("/doc/getBaseInfo");
    }

}
