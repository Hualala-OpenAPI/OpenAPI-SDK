package com.hualala.openapi.sdk.beans.request.order;

import lombok.Data;

@Data
public class ReturnFoodInfoBean {
    private Long foodID;
    private String foodName;
    private String foodUnit;
    private Long foodUnitID;
    private Long foodCategoryID;
    private String foodCategoryName;
    private String itemDetail;
    private Integer isDiscount;
    private String remark;
    private String duePrice;
    private Integer batchNo;
    private String sequenceID;
    private String returnFoodCount;
    private String foodCode;
    private Integer isBatching;
    private String SFMUnitCode;
    private Integer isSetFood;
    private Integer isSFDetail;
    private Integer isGift;
    private String unit;
    private String unitKey;
    private String price;
    private String foodKey;
    private String payPrice;
}
   
    