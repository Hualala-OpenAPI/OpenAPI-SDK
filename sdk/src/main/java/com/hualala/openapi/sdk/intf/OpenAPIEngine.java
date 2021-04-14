package com.hualala.openapi.sdk.intf;

import com.hualala.openapi.sdk.responses.DocBaseInfoResponse;

public interface OpenAPIEngine {
    //基本档
    DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID);
    //订单
    //账单
    //会员
    //营销
}
