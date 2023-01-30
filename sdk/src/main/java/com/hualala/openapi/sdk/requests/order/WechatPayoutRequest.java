package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.WechatPayoutBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class WechatPayoutRequest extends BaseRequest<WechatPayoutBean> {
    public WechatPayoutRequest() {
        super("/order/payout");
    }
}
   
    