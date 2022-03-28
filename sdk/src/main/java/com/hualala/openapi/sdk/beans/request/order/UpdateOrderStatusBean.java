package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

/**
 * @ Description：
 */
@Data
public class UpdateOrderStatusBean extends BaseBean {
    private String orderKey;
    private Integer thirdPartyStatus;
    private String cancelOrderCause;
    private Long takeoutConfirmTime;
    private String takoutConfirmRemark;
    private String orderRemark;
    private String operator;
    private ShipperInfoBean shipperInfoVo;
    private String refundAmount;
}
   
    