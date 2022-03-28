package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class CreateOrderBean extends BaseBean {
    private OrderCommonBean header;
    private Integer isCheackOut;//0 默认 不需要收银台数据， 1 需要收银台数据
    private Integer isThirdPay;//是否包含第三方支付 1不包含，2包含
    private String bankCode;//weChat微信  aliPay支付宝
    private Integer checkoutType;//支付类型（1：微信餐厅先付，2：微信餐厅后付，3：储值并消费,4:代付，5：预点餐）
    private WechatOrderMasterBean order;
    private Integer isSentMsg;
    private Integer handleType;//1、结账2、加菜
    private String thirdOrderID;
    private Integer msgType;
    private String paidTotalAmount;
}
   
    