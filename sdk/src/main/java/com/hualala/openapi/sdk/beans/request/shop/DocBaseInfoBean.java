package com.hualala.openapi.sdk.beans.request.shop;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class DocBaseInfoBean extends BaseBean {

    private String merchantsName;
    private Boolean pagination; // 是否分页
    private Integer pageNo; // 页码
    private Integer pageSize; // 每页行数
    private String type;
    private String orgCode;
    private String discountWayKey;//折扣记录ID
    private Integer isReadCreditCustInfoFromCRM; // 是否从会员服务中查询
    private String empCode; // 员工编号
    private Boolean isActive; // 是否有效，false:返回全部；true:仅返回有效。默认为false
    private List<AddGroupFoodBean> addGroupfoodVoList; //批量创建菜品
    private List<UpdateGroupFoodBean> updateGroupFoodVoList;//批量修改菜品信息
    private DelMultiGroupFoodVo delMultiGroupFoodVo;//批量删除菜品信息
    private String bookID;//菜谱ID
    private String isReturnBrandName;//是否返回品牌名称，1：是
    private String departmentType;
    private String departmentName;
    private String foodCategoryID;
    private String foodCategoryIDs;

    @Data
    public static class DelMultiGroupFoodVo {
        private String bookID; //菜谱ID不能为空
        private String foodIDs; //菜品ID不能为空
        private String foodName;
        private String bookName;
    }

}
