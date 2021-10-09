package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
public class BillMaster {
    private Long groupID = 0L;
    private Long shopID = 0L;
    private String shopName = StringUtils.EMPTY;
    private Long reportDate = 0L;
    private String orderKey = StringUtils.EMPTY;
    private String orderNo = StringUtils.EMPTY;
    private String deviceOrderNo = StringUtils.EMPTY;
    private String lockedFlag = StringUtils.EMPTY;
    private String timeNameStart = StringUtils.EMPTY;
    private String timeNameCheckout = StringUtils.EMPTY;
    private String areaName = StringUtils.EMPTY;
    private String tableName = StringUtils.EMPTY;
    private String channelKey = StringUtils.EMPTY;
    private String channelName = StringUtils.EMPTY;
    private String channelOrderNo = StringUtils.EMPTY;
    private String channelOrderKey = StringUtils.EMPTY;
    private String channelUserID = StringUtils.EMPTY;
    private String channelUserKey = StringUtils.EMPTY;
    private String channelUserImage = StringUtils.EMPTY;
    private String channelOrderTime = StringUtils.EMPTY;
    private Integer orderSubType = 0;
    private String netOrderTypeCode = StringUtils.EMPTY;
    private Integer person = 0;
    private String createBy = StringUtils.EMPTY;
    private String waiterBy = StringUtils.EMPTY;
    private Long startTime = 0L;
    private Long checkoutTime = 0L;
    private String checkoutBy = StringUtils.EMPTY;
    private Integer orderStatus = 0;
    private Integer isTestOrder = 0;
    private String orderMD5 = StringUtils.EMPTY;
    private Integer foodCount = 0;
    private BigDecimal foodAmount = BigDecimal.ZERO;
    private BigDecimal sendFoodAmount = BigDecimal.ZERO;
    private BigDecimal sendCouponAmount = BigDecimal.ZERO;
    private String sendCouponRemark = StringUtils.EMPTY;
    private String cardNo = StringUtils.EMPTY;
    private String cardKey = StringUtils.EMPTY;
    private String cardTransID = StringUtils.EMPTY;
    private String customerName = StringUtils.EMPTY;
    private String cardTransAfterRemark = StringUtils.EMPTY;
    private String discountBy = StringUtils.EMPTY;
    private String discountWayKey = StringUtils.EMPTY;
    private String discountWayName = StringUtils.EMPTY;
    private BigDecimal discountRate = BigDecimal.ZERO;
    private Integer discountRange = 0;
    private Integer isVipPrice = 0;
    private Integer moneyWipeZeroType = 0;
    private BigDecimal specialStatAmount = BigDecimal.ZERO;
    private BigDecimal promotionAmount = BigDecimal.ZERO;
    private String promotionDesc = StringUtils.EMPTY;
    private BigDecimal paidAmount = BigDecimal.ZERO;
    private String invoiceBy = StringUtils.EMPTY;
    private String invoiceTitle = StringUtils.EMPTY;
    private String invoiceTaxpayerIdentCode = StringUtils.EMPTY;
    private BigDecimal invoiceAmount = BigDecimal.ZERO;
    private BigDecimal invoiceTaxRate = BigDecimal.ZERO;
    private BigDecimal invoiceTaxAmount = BigDecimal.ZERO;
    private String userName = StringUtils.EMPTY;
    private Integer userSex = 0;
    private String userMobile = StringUtils.EMPTY;
    private String userAddress = StringUtils.EMPTY;
    private String modifyOrderLog = StringUtils.EMPTY;
    private Integer YJZCount = 0;
    private Integer FJZCount = 0;
    private String alertFlagLst = StringUtils.EMPTY;
    private String foodAlert = StringUtils.EMPTY;
    private String foodNameDetail = StringUtils.EMPTY;
    private String payAlert = StringUtils.EMPTY;
    private String orderRemark = StringUtils.EMPTY;
    private String deviceKey = StringUtils.EMPTY;
    private String deviceCode = StringUtils.EMPTY;
    private String deviceName = StringUtils.EMPTY;
    private String serverMAC = StringUtils.EMPTY;
    private String reviewBy = StringUtils.EMPTY;
    private Long reviewTime = 0L;
    private String shiftTime = StringUtils.EMPTY;
    private Integer action = 0;
    private Long actionTime = 0L;
    private Long createTime = 0L;
    private Long uploadTime = 0L;
    private Byte isCreatedByLoginUser = 0;
    private String deviceGroupID = StringUtils.EMPTY;
    private String deviceGroupName = StringUtils.EMPTY;
    private Integer advanceOrderFlag = 0; //预订单标识（0非预订单，1预订单）
    private String parentOrderKey = StringUtils.EMPTY;
    private String channelOrderKeyTP = StringUtils.EMPTY;
    private Integer chargeBackFlag = null; //空值说明saas版本有问题. 0: 正常单(默认), 1: 退单, 2: 冲销单, 3: 部分冲销单

    public void setSaasOrderKey(String v) {
        this.orderKey = v;
    }

    public void setSaasOrderNo(String v) {
        this.orderNo = v;
    }

    public void setSaasOrderRemark(String v) {
        this.orderRemark = v;
    }
}
