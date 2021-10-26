package com.hualala.openapi.sdk.beans.request.deliver;

import lombok.Data;

@Data
public class DistribOrderInfoBean {

    private Long groupID;

    private Long shopID;

    private int shipPlatformCode;

    private String orderKey;

    private String shopName;

    private String groupName;

    private String receiverName;

    private String receiverAddress;

    private String receiverLongitude;

    private String receiverLatitude;

    private String receiverPhone;

    private String receiverTel;

    private double tips;

    private String remakes;

    private Double cargoPrice;

    private String bizSrcType;

    private String orderSrcType;

    private String invoiceTitle;

    private int ruleType;

    private int cargoWeight;

    private int cargoNum;

    private int payType;

    private int orderPaymentStatus;

    private int productTypeNum;

    private double orderActualAmount;

    private String product;

    private String pushOrderName;

    private int lnglatType;

    private String upstreamOrderKey;

    private String takeOutOrderKey;

    private String transAction;

    private String serviceProvider;

    private String spGroupId;

    private int repeatable;

    private int businessType;

    private String orderSourceNo;

    private int pickUpType;
}
