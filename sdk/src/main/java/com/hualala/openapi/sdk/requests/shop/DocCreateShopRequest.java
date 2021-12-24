package com.hualala.openapi.sdk.requests.shop;

import com.hualala.openapi.sdk.beans.request.shop.DocCreateShopBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DocCreateShopRequest extends BaseRequest<DocCreateShopBean> {

    public DocCreateShopRequest() {
        this.path = "/v2/doc/createShop";
    }

}
