package com.hualala.openapi.sdk.beans.request.bill;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

@Data
public class QueryBillDetailByReportDateBean extends BaseBean {
    private Long reportDate;
    private Integer pageNo;
    private Integer pageSize;
}
