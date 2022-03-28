package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

/**
 * @ Description：订单实体类
 */
@Data
public class WechatUserInfoBean {
    private String userID;
    private String userName;
    private String openID;//对应hualalaMpID
    private String userMobile;
    private String shopMpID; //店铺公众号ID string ShopweixinID=37;
    private String hualalaMpID;//哗啦啦公众号ID   string weixinID=37;
    private String cardID;
    private String cardTypeID;
    private String cardNo;
    private String userSex; //0男 1女
    private String mPid; // need 微信公众号支付必传
    private String shopOpenID; //对应shopMpID
    private String appID;
}
   
    