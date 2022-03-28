package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

import java.util.List;

/**
 * @ Description：实体类
 */
@Data
public class WechatOrderMasterBean {
    private Long orderID;
    private Long orderKey;
    private String quoteID;
    private Long groupID;
    private String groupName;
    private Long shopID;
    private String shopName;
    private String shopAddress;
    private String shopTel;
    private Integer orderType;
    private Integer orderSubType;
    private Integer orderStatus;
    private Integer orderState;
    private WechatUserInfoBean userInfo;
    private String brandID;
    private String originTotalAmount;
    private String dueTotalAmount;
    private String discountTotalAmount;
    private String refundTotalAmount;
    private String appliedPromoteIDS;
    private String taxNo;
    private String invoiceTitle;
    private String orderRemark;
    private String cannelRemark;
    private String cannelTime;
    private String submitTime;
    private String clientID;
    private String cityID;
    private String cityName;
    private String longitude;
    private String latitude;
    private String tableName;
    private Integer dinners;
    private String msgID;
    private String orderTime;
    private String acceptTime;
    private String takeoutTime;
    private String takeoutRemark;
    private String takeoutConfirmTime;
    private List<WechatOrderItemBean> orderItem;
    private List<PaymentDetailBean> payment;
    private String promotionInfo;
    private String takeoutAddress;
    private String deliveryAmount;
    private String takeoutPackagingAmount;
    private String foodAmount;
    private String foodCuount;
    private String serviceAmount;
    private String channelKey;
    private String shopImgUrl;
    private String shopOrderKey;
    private String shopOrderKeyFolwNo;
    private String offlinePaidAmount;
    private String stdChannelKey;
    private Integer checkoutType;
    private String selectCardInfo;
    private String unionID;
    private String isAlreadyPaid;
    private Integer orderMode;
    private String officalAddress; // 官方地址，韩国配送外卖使用
    private OrderExtraInfoBean orderExtraInfo;
    private String blessingWords;  //新增支持祝福语字段上传
    private String dropRoadAddress;// 道路地址，韩国配送外卖使用
}

