package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

import java.util.Map;

/**
 * @ Description：订单实体类
 */
@Data
public class UserInfoBean {
    private Long userID;
    private String userName;
    private Integer groupID;
    private Integer shopID;
    private String weixinID;
    private String shopWeixinID;
    private String userMobile;
    private String shopMpID;
    private String cardKey;
    private String cardNo;
    private Map<String, String> properties;
}
   
    