package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
public class BillAttach {
    private Long shopID = 0L;
    private Long orderID = 0L;
    private String orderKey = StringUtils.EMPTY;
    private String groupName = StringUtils.EMPTY;
    private Integer tableID = 0;
    private String shopOrderKey = StringUtils.EMPTY;
    private String shopOrderFlowNo = StringUtils.EMPTY;
    private String platformOrderID = StringUtils.EMPTY;
    private BigDecimal prepaymentAmount = BigDecimal.ZERO;
    private BigDecimal serviceAmount = BigDecimal.ZERO;
    private Integer posMsgAdvanceSendMinutes = 0;
    private String checkRemark = StringUtils.EMPTY;
    private Long checkStartTime = 0L;
    private Long checkEndTime = 0L;
    private Long checkPWDTime = 0L;
    private String takeoutAddress = StringUtils.EMPTY;
    private String takeoutDescribe = StringUtils.EMPTY;
    private Integer takeoutConfirmType = 0;
    private String takeoutConfirmRemark = StringUtils.EMPTY;
    private BigDecimal takeoutPackagingAmount = BigDecimal.ZERO;
    private Long cancelOrderTime = 0L;
    private String cancelOrderCause = StringUtils.EMPTY;
    private BigDecimal shopRefundAmount = BigDecimal.ZERO;
    private BigDecimal orderRefundAmount = BigDecimal.ZERO;
    private boolean isAutoRefundAmount = false;
    private Integer orderStatus = 0;
    private Integer payStatus = 0;      //订单在云端的支付状态
    private Integer orderTransformStatus = 8;  //8:默认未接单
    private BigDecimal specialFreeAmount = BigDecimal.ZERO;
    private BigDecimal freeAmount = BigDecimal.ZERO;
    private BigDecimal giftAmount = BigDecimal.ZERO;
    private String giftName = StringUtils.EMPTY;
    private Integer giftCount = 0;
    private Integer clientType = 0;
    private Long orderTime = 0L;
    private Long orderCreateTime = 0L;
    private Long orderSubmitTime = 0L;
    private Long chooseStartTime = 0L;
    private Long chooseEndTime = 0L;
    private Long payStartTime = 0L;
    private Long payEndTime = 0L;
    private Long acceptTime = 0L;
    private Long submitTime = 0L;
    private String dataSign = StringUtils.EMPTY;
    private Integer deliverSource = 0;
    private String deliverSourceOrderKey = StringUtils.EMPTY;
    private Integer deliverStatus = 0;
    private String deliverSourceStatus = StringUtils.EMPTY;
    private BigDecimal deliverFee = BigDecimal.ZERO;
    private BigDecimal deliverTips = BigDecimal.ZERO;
    private String transporter = "::";
    private Long deliverAcceptTime = 0L;
    private Long deliverFetchTime = 0L;
    private Long deliverArriveTime = 0L;
    private Long deliverCancelTime = 0L;
    private String deliverCancelReason = StringUtils.EMPTY;
    private BigDecimal deductFee = BigDecimal.ZERO;
    private Long deliverStatusUpdateTime = 0L;
    private Long deliverCreateTime = 0L;
    private String deliverArea = StringUtils.EMPTY;
    private String inviteCode = StringUtils.EMPTY;
    private Integer action = 0;
    private Long actionTime = 0L;
    private Long createTime = 0L;

    //json序列化用的, 勿删
    public int getIsAutoRefundAmount() {
        return isAutoRefundAmount ? 1 : 0;
    }
}
