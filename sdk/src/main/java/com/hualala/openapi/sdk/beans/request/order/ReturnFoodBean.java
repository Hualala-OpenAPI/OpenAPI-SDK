package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class ReturnFoodBean extends BaseBean {
    private Long orderKey;
    private String foodAmount;
    private String foodCount;
    private String promotionAmount;
    private String originTotalAmount;
    private String dueTotalAmount;
    private String partRefundTotalAmount;
    private String refundChannelName;
    private String channelKey;
    private String takeoutPackagingAmount;
    private List<ReturnFoodInfoBean> returnFood;
    private List<PaymentDetailBean> returnPayLst;
    private Integer isNeedConfim;
    private String dataSign;

}
   
    