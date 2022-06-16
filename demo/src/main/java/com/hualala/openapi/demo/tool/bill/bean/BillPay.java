package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
public class BillPay {
    private Long reportDate = 0L;
    private Long groupID = 0L;
    private Long shopID = 0L;
    private String orderKey = StringUtils.EMPTY;
    private String shopName = StringUtils.EMPTY;
    private Integer orderStatus = 0;
    private String checkoutBy = StringUtils.EMPTY;
    private String paySubjectKey = StringUtils.EMPTY;
    private String paySubjectCode = StringUtils.EMPTY;
    private String paySubjectName = StringUtils.EMPTY;
    private String paySubjectGroupName = StringUtils.EMPTY;
    private BigDecimal paySubjectRate = BigDecimal.ZERO;
    private Integer isJoinReceived = 0;
    private BigDecimal debitAmountGiftTotal = BigDecimal.ZERO;
    private BigDecimal debitAmount = BigDecimal.ZERO;
    private BigDecimal creditAmount = BigDecimal.ZERO;
    private BigDecimal paySubjectRealAmount = BigDecimal.ZERO;
    private String giftItemNoLst = StringUtils.EMPTY;
    private String payRemark = StringUtils.EMPTY;
    private String payTransNo = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private String serverMAC = StringUtils.EMPTY;
    private String deviceName = StringUtils.EMPTY;
    private Long actionTime = 0L;
    private Long createTime = 0L;
    private Integer isIncludeScore = 0;
    private Integer isPhysicalEvidence = 0;
    private Integer isFeeJoinReceived = 0;
    private BigDecimal paySubjectFeeAmount = BigDecimal.ZERO;
    private BigDecimal paySubjectDiscountAmount = BigDecimal.ZERO;
    private BigDecimal paySubjectReceivedAmount = BigDecimal.ZERO;
    private BigDecimal paySubjectAllDiscountAmount = BigDecimal.ZERO;
    private String memberCardID = StringUtils.EMPTY;
    private String promotionID = StringUtils.EMPTY;
    private String programType = StringUtils.EMPTY;
    private Integer paySubjectCount = 0;
    private String paymentID = StringUtils.EMPTY;   //支付单号
    private String morePayParams = StringUtils.EMPTY;   //扩展参数. 已知可能含有thirdPartyPayTransNo(第三方支付单号), tradeNO(具体含义不详,余力说好像是会员卡支付的交易单号)
	
    public void setSaasOrderKey(String value) {
        this.orderKey = value;
    }
}
