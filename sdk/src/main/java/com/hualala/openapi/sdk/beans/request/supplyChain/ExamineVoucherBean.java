package com.hualala.openapi.sdk.beans.request.supplyChain;

import lombok.Data;

@Data
public class ExamineVoucherBean {
    private Long groupID;
    private Integer demandType;
    private Integer importStatus;
    private Integer startVoucherDate;
    private Long billStartDate;
    private Integer voucherStatus;
    private String supplierID;
    private String voucherTypeIDs;
    private Integer pageNo;
    private Integer pageSize;
    private Integer pageFlag;
}
