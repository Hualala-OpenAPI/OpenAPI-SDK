package com.hualala.openapi.sdk.requests.supplyChain;

import com.hualala.openapi.sdk.beans.request.supplyChain.AllotGoodsBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class AllotGoodsRequest extends BaseRequest<AllotGoodsBean> {

    public AllotGoodsRequest() {
        this.path = "/v2/supplyChain/allotGoods";
    }

}
