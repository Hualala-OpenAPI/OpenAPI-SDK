package com.hualala.openapi.sdk.beans.request.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ Description：订单实体类
 */
@Data
public class WechatOrderItemBean {
    @JSONField(name = "SFMUnitCode")
    private String SFMUnitCode;
    private Integer id; //query
    private Long orderKey;//返回数据
    private Integer foodID;//need
    private String foodName;//need
    private String foodUnit;//菜品规格
    private String foodUnitID;//菜品规格ID
    private String foodCategoryID; //菜品分类ID
    private String foodCategoryName;//菜品分类
    private Integer isSetFood;//need
    private Integer isSFDetail;//是否是套餐明细
    private Integer foodSortIndex;//菜品排序
    private Integer isBatching;//0:正常菜,1:配菜,2:主菜,3:加价做法
    private Integer isGift;//是否赠菜
    // private Integer foodCount;//菜品数量
    private String foodCount;//菜品数量
    private String remark;//need
    private String originPrice; //need菜品原价
    private String takeoutPackagingFee;//打包费
    private Integer isDiscount;//是否打折
    private String promoteTags;//营销标志
    private String childPromotionTags;//父菜PromotionTags
    private String duePrice;//need菜品成交价
    private String createTime;//query
    private String cookMethod; // 做法
    private String taste;//口味
    private String vipPrice;//会员价
    private String batchNo;//加菜批次 0代码旧菜，1代表新加的菜
    private String itemDetail;//透传json

    //新增字段
    private String foodKey;//商户中心
    private String foodCode;//商户中心
    private String foodUnitKey;//商户中心
    private String foodUnitCode;//商户中心
    private String unitAdjuvant;//商户中心-辅助规格
    private String unitAdjuvantNumber;//商户中心-辅助规格数量
    private String foodCategoryKey;//商户中心-菜品分类Name
    private String foodCategoryGroupName;//商户中心-菜品分类分组Name
    private String foodCategorySortIndex;//菜品分类排序
    private String foodSubjectKey;//菜品对应收入科目Key
    private String foodSubjectCode;//菜品对应收入科目Code
    private String foodSubjectName;//菜品对应收入科目Name
    private String departmentKeyLst;//出品部门Key列表，多个间用逗号隔开"
    private String isTempFood;//是否临时菜
    private String setFoodCategoryName;//套餐明细所属的套餐分类名字
    private String isNeedConfirmFoodNumber;
    private String itemkey;//套餐关系
    private String parentItemKey;
    private String promotionList;//该菜品执行的营销信息
    private String sequenceID;
}
   
    