package com.hualala.openapi.demo.tool.bill.bean;

import lombok.Data;

import java.util.List;

@Data
public class Bill {
    private BillMaster master;
    private List<BillFood> foodLst;
    private List<BillPay> payLst;
    private List<BillFoodPromotion> foodPromotionList;
    private BillAttach orderAttach;//送餐信息
}
