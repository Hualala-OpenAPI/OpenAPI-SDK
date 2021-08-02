package com.hualala.openapi.sdk.beans.request.bill;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class QueryBillDetailBean extends BaseBean {
    private Long reportDate;
    private String saasOrderKeys;
}
