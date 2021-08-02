package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by feichen on 18/9/25.
 */
@Data
public class BillFood {
    private Long reportDate = 0L;
    private Long groupID = 0L;
    private Long shopID = 0L;
    private String orderKey = StringUtils.EMPTY;
    private String shopName = StringUtils.EMPTY;
    private Integer orderStatus = 0;
    private Integer orderSubType = 0;
    private String itemKey = StringUtils.EMPTY;
    private String parentFoodFromItemKey = StringUtils.EMPTY;
    private String areaName = StringUtils.EMPTY;
    private String tableName = StringUtils.EMPTY;
    private Integer foodCategorySortIndex = 0;
    private String foodCategoryKey = StringUtils.EMPTY;
    private String foodCategoryName = StringUtils.EMPTY;
    private String foodSubjectKey = StringUtils.EMPTY;
    private String foodSubjectCode = StringUtils.EMPTY;
    private String foodSubjectName = StringUtils.EMPTY;
    private String departmentKeyLst = StringUtils.EMPTY;
    private String departmentKeyOne = StringUtils.EMPTY;
    private Integer isSetFood = 0;
    private Integer isSFDetail = 0;
    private Integer isBatching = 0;
    private String foodKey = StringUtils.EMPTY;
    private String foodName = StringUtils.EMPTY;
    private String setFoodName = StringUtils.EMPTY;
    private String setFoodRemark = StringUtils.EMPTY;
    private BigDecimal foodNumber = BigDecimal.ZERO;
    private BigDecimal foodCancelNumber = BigDecimal.ZERO;
    private BigDecimal foodLastCancelNumber = BigDecimal.ZERO;
    private BigDecimal foodSendNumber = BigDecimal.ZERO;
    private String cancelReason = StringUtils.EMPTY;
    private String cancelBy = StringUtils.EMPTY;
    private Long cancelTime = 0L;
    private String sendReason = StringUtils.EMPTY;
    private String sendBy = StringUtils.EMPTY;
    private Long sendTime = 0L;
    private Integer isNeedConfirmFoodNumber = 0;
    private Integer isTempFood = 0;
    private String unit = StringUtils.EMPTY;
    private String unitKey = StringUtils.EMPTY;
    private String unitAdjuvant = StringUtils.EMPTY;
    private BigDecimal unitAdjuvantNumber = BigDecimal.ZERO;
    private Integer isDiscount = 0;
    private Integer isDiscountDefault = 0;
    private BigDecimal categoryDiscountRate = BigDecimal.ZERO;
    private BigDecimal foodEstimateCost = BigDecimal.ZERO;
    private BigDecimal foodProPrice = BigDecimal.ZERO;
    private BigDecimal foodVipPrice = BigDecimal.ZERO;
    private BigDecimal foodPayPrice = BigDecimal.ZERO;
    private BigDecimal foodPayPriceReal = BigDecimal.ZERO;
    private BigDecimal foodPriceAmount = BigDecimal.ZERO;
    private BigDecimal foodRealAmount = BigDecimal.ZERO;
    private String foodRemark = StringUtils.EMPTY;
    private String foodTaste = StringUtils.EMPTY;
    private String foodPractice = StringUtils.EMPTY;
    private String allFoodRemark = StringUtils.EMPTY;
    private String modifyReason = StringUtils.EMPTY;
    private String modifyBy = StringUtils.EMPTY;
    private Long modifyTime = 0L;
    private String orderBy = StringUtils.EMPTY;
    private String serveConfirmBy = StringUtils.EMPTY;
    private Long serveConfirmTime = 0L;
    private BigDecimal readyNumber = BigDecimal.ZERO;
    private BigDecimal makeEndNumber = BigDecimal.ZERO;
    private BigDecimal transmitNumber = BigDecimal.ZERO;
    private Integer makeStatus = 0;
    private Long makeStartTime = 0L;
    private String makeBy = StringUtils.EMPTY;
    private Integer makeCallCount = 0;
    private Long makeEndTime = 0L;
    private BigDecimal makeEndfoodNumber = BigDecimal.ZERO;
    private Integer printStatus = 0;
    private String actionBatchNo = StringUtils.EMPTY;
    private String serverMAC = StringUtils.EMPTY;
    private String deviceName = StringUtils.EMPTY;
    private BigDecimal salesCommission = BigDecimal.ZERO;
    private String clientType = StringUtils.EMPTY;
    private Long actionTime = 0L;
    private Long createTime = 0L;
    private BigDecimal taxRate = BigDecimal.ZERO;
    private BigDecimal foodDiscountRate = BigDecimal.ZERO;
    private BigDecimal foodRealPrice = BigDecimal.ZERO;
    private String setFoodCategoryName = StringUtils.EMPTY;
    private String foodSubType = StringUtils.EMPTY;
    private String promotionIDLst = StringUtils.EMPTY;
    private String foodCode = StringUtils.EMPTY;

    public void setSaasOrderKey(String value) {
        this.orderKey = value;
    }
}
