package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

@Data
public class OrderExtraInfoBean {
    private Integer coordinateName;
    private String channelOrderKey;
    private Integer shippingMethod;
    private String thirdFetchNumber;
    private String thirdFlowNumber;
    private Integer fetchNumberType;
    private Integer shopDelivery; //0-非饿了么平台外卖单, 平台配送; 1-非饿了么平台外卖单, 店铺自配送; 2-饿了么订单、平台配送, 3-饿了么订单、店铺自配送
}
   
    