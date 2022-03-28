package com.hualala.openapi.sdk.beans.request.shop;

import lombok.Data;

/**
 * @ Description：
 */
@Data
public class AddGroupFoodBean {
    private String foodKey;
    private String groupID; //集团ID不能为空
    private String bookID; //菜谱ID不能为空
    private long brandID;
    private String foodCategoryID; //菜品分类ID不能为空
    private String foodCategoryKey;
    private int batchingFoodCategoryID;
    private int batchingIsFoodNumberRate;
    private String batchingFoodCategoryKey;
    private int isSingleSale;
    private int foodPFCategoryID;
    private String foodCode;
    private String foodMnemonicCode;
    private String unitAdjuvant;
    private String foodName; //菜品名称不能为空
    private String foodEnName;
    private String foodAliasName;
    private int parentFoodID;
    private int sortIndex;
    private int printSortIndex;
    private int isAutoAdd;
    private int IsNeedConfirmFoodNumber;
    private int minOrderCount;
    private double incrementUnit;
    private int isCanRefund;
    private int isSpecialty;
    private int isRecommend;
    private int isNew;
    private int isDiscount;
    private int isComments;
    private int isActive;
    private int isOpen;
    private int isTempFood = 0;
    private int isSetFood = 0;
    private String setFoodDetailLst;
    private String setFoodDetailJson;
    private int setPerson;
    private int takeawayTag;
    private double takeoutPackagingFee;
    private int workingLunchTag;
    private int hotTag;
    private String tasteList;
    private int tasteIsRequired;
    private int tasteIsMultiple;
    private String makingMethodList;
    private int makingMethodIsRequired;
    private int makingMethodIsMultiple;
    private long adsID;
    private String description;
    private String imgePath;
    private int isHasImage;
    private double imageHWP;
    private String material2DUrl;
    private double material2DHWP;
    private String material3DUrl;
    private double material3DHWP;
    private int isShowInEBook;
    private int initClickAmount;
    private String departmentKeyLst;
    private String foodSubjectKey;
    private int actualClickAmount;
    private int recentClickAmount;
    private String clickAlertMess;
    private int starLevel;
    private long sourceFoodID;
    private double salesCommission;
    private String foodKeyElementLst;
    private int detailSplit;
    private String supportFood;
    private int popularity;
    private String assistUnit;
    private double taxRate;
   // List<GroupFoodPriceDetail> foodPrieInfos;
    private String foodOnlineCategoryID;
    private String foodOnlineCategoryKey;
    private String foodOnlineName;
    private String tagIDs;
    private String salDayType = "0"; //售卖日期类型(0不限制时间，1自定义时间)不能为空
    private String salBeginDay = "";
    private String salEndDay = "";
    private String mon = "0";
    private String tues = "0";
    private String wed = "0";
    private String thur = "0";
    private String fri = "0";
    private String sat = "0";
    private String sun = "0";
    private String salTimeType = "0"; //售卖时段类型(0不限制时间，1自定义时间)不能为空
    private String salTimeJson = "";
    private int isTempSetFood = 0;
    private String departmentKey1;
    private String departmentKey2;
    private String departmentKey3;
    private String departmentKey4;
    private String departmentKey5;
    private String sourceCreate = "集团";
    private int batchingFoodTagID = 0;
}
   
    