package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class ThirdOrderBean extends BaseBean {
    private Integer isCheackOut;
    private Integer isThirdPay;
    private String bankCode;
    private Integer isSentMsg;
    private String thirdOrderID;
    private Integer msgType;
    private String paidTotalAmount;
    private Integer handleType;//1、结账2、加菜
    private Integer checkoutType;//支付类型（1：微信餐厅先付，2：微信餐厅后付，3：储值并消费,4:代付，5：预点餐）
    private OrderCommonBean header;
    private WechatOrderMasterBean order;

}




