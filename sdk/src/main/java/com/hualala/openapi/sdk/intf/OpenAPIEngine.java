package com.hualala.openapi.sdk.intf;

import com.hualala.openapi.sdk.beans.request.crm.QueryUnionIDListBean;
import com.hualala.openapi.sdk.beans.request.promotion.QueryUserCouponDetailListBean;
import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.shop.DocCreateShopBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.AllotGoodsBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailByReportDateResponse;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailResponse;
import com.hualala.openapi.sdk.responses.bill.QueryReportGeneralServiceResponse;
import com.hualala.openapi.sdk.responses.equityAccount.QueryProductItemsResponse;
import com.hualala.openapi.sdk.responses.order.ThirdOrderResponse;
import com.hualala.openapi.sdk.responses.promotion.QueryUserCouponDetailListResponse;
import com.hualala.openapi.sdk.responses.report.DataUploadResponse;
import com.hualala.openapi.sdk.responses.shop.DocBaseInfoResponse;
import com.hualala.openapi.sdk.responses.shop.DocCreateShopResponse;
import com.hualala.openapi.sdk.responses.shop.DocOpenFoodResponse;
import com.hualala.openapi.sdk.responses.supplyChain.AllotGoodsResponse;
import com.hualala.openapi.sdk.responses.supplyChain.ExamineVoucherResponse;

import java.util.List;

public interface OpenAPIEngine {
    //基本档
    //todo format response
    String getDocAllShops(long groupID);

    DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID);

    DocOpenFoodResponse getMenu(Long groupID, Long shopID);

    //返回格式不标准, 用 string 接收 response
//    DocCreateShopResponse createShop(Long groupID, DocCreateShopBean shop);
    String createShop(Long groupID, DocCreateShopBean shop);

    //订单
    ThirdOrderResponse thirdOrder(ThirdOrderRequest request);

    //账单
    //会员
    String queryUnionIDs(long groupID, QueryUnionIDListBean bean);

    //营销
    String queryUserCouponDetailList(QueryUserCouponDetailListBean bean);

    //供应链
    ExamineVoucherResponse queryExamineVoucher(long groupID, ExamineVoucherBean bean);

    AllotGoodsResponse allotGoods(long groupID, AllotGoodsBean bean);

    //报表
    DataUploadResponse dataUpload(long groupID, long shopID, DataUploadBean bean);

    QueryBillDetailResponse queryBillDetail(long groupID, long shopID, long reportDate, List<String> saasOrderKeys);

    QueryBillDetailByReportDateResponse queryBillDetailByReportDate(long groupID, long shopID, long reportDate, int pageNo, int pageSize);
    QueryReportGeneralServiceResponse queryReportGeneralService(long groupID, Long shopID, long reportDate, int pageNo, int pageSize);

    //权益账户
    QueryProductItemsResponse queryProductItemsByProductCategory(long groupID, String source);
}
