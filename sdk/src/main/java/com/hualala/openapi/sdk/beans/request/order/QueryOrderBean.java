package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class QueryOrderBean extends BaseBean {
    private OrderCommonBean header;
    private String orderKey;
    private String userID;
    private String orderID;
    private String shopName;
    private String targetStatus;
    private String cancelOrderCause;
    private String refundType;
}
   
    