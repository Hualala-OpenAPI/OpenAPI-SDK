package com.hualala.openapi.sdk.beans.request.bill;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class QueryBillReportBean extends BaseBean {
    private Long reportDate;
    private String maxReportDate;
    private String minReportDate;
    private Integer pageNo;
    private Integer pageSize;
}
