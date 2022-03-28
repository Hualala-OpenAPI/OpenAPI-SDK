package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class ApplyRefundBean extends BaseBean {
    private Long orderKey;
    private String cancelOrderCause;
    private Integer channel;
}
   
    