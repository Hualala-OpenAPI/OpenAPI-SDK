package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
public class BillFoodPromotion {
    private Long reportDate = 0L;
    private Long groupID = 0L;
    private Long shopID = 0L;
    private String orderKey = StringUtils.EMPTY;
    private String shopName = StringUtils.EMPTY;
    private String itemKey = StringUtils.EMPTY;
    private Long promotionID = 0L;
    private String promotionCategoryName = StringUtils.EMPTY;
    private String promotionType = StringUtils.EMPTY;
    private String promotionCode = StringUtils.EMPTY;
    private String promotionName = StringUtils.EMPTY;
    private String promotionTagLst = StringUtils.EMPTY;
    private String foodName = StringUtils.EMPTY;
    private String unitKey = StringUtils.EMPTY;
    private BigDecimal foodCount = BigDecimal.ZERO;
    private BigDecimal deltaPromotionAmount = BigDecimal.ZERO;
}
