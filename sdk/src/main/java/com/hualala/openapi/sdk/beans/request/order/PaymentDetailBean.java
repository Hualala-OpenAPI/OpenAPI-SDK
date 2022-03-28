package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

@Data
public class PaymentDetailBean {
    private String pID;
    private String paymentID;
    private String paymentSubjectID;
    private String paymentSubjectName;
    private String payorAccount;
    private String payeeAccount;
    private String cardTypeID;
    private String dueAmount;
    private String paidAmount;
    private String payload;
    private Integer paymentStatus;
    private String payBeginTime;
    private String payEndTime;
    private Integer payWay;
    private String balanceID;
    private String couponID;
    private String pointAmount;
    private String payID;
    private String isJoinReceived;
    private String isIncludeScore;
    private String paySubjectRate;
    private String isFeeJoinReceived;
    private String isPhysicalEvidence;
    private String payTransNo;
    private String giftItemNoLst;
    private String giftItemCount;
    private String memberCardID;
    private String memberCardNO;
    private String crmChannelID;
    private String promotionID;
    private String programType;
    private String paySubjectKey;
    private String paySubjectGroupName;
    private String morePayParams;
}
   
    