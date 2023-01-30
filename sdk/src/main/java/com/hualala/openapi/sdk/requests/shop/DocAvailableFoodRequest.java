package com.hualala.openapi.sdk.requests.shop;

import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class DocAvailableFoodRequest extends BaseRequest<DocBaseInfoBean> {
    public DocAvailableFoodRequest() {
        super("/inventory/getAvailableFoodRemainQtyByShopID");
    }
}
   
    