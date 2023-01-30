package com.hualala.openapi.sdk.requests.shop;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DocGetAllShopsRequest extends BaseRequest<BaseBean> {

    public DocGetAllShopsRequest() {
        super("/doc/getAllShop");
    }

}
