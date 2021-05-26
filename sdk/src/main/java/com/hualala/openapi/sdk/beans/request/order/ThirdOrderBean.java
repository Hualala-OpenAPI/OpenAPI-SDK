package com.hualala.openapi.sdk.beans.request.order;

import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class ThirdOrderBean extends BaseBean {
    private Integer isCheackOut;
    private Integer isThirdPay;
    private String bankCode;
    private JSONObject order;
    private Integer isSentMsg;
    private String thirdOrderID;
    private Integer msgType;
    private String paidTotalAmount;
}
