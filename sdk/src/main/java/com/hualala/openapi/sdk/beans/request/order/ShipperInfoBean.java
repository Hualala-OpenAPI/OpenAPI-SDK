package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

@Data
public class ShipperInfoBean {
    private String customerPhone;
    private String remark;
    private String shipperName;
    private String shipperPhone;
    private Integer statusCode;
    private String statusMsg;
    private String shippingMethod;
    private String shopDeliveryAmount;
}
   
    