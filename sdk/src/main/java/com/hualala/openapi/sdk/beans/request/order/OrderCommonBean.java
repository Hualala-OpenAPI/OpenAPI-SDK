package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

@Data
public class OrderCommonBean {
    private String traceID;
    private UserInfoBean userInfo;
}

