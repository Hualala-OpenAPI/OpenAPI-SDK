package com.hualala.openapi.sdk.helper;

import com.hualala.openapi.sdk.beans.request.bill.QueryBillDetailBean;
import com.hualala.openapi.sdk.beans.request.bill.QueryBillDetailByReportDateBean;
import com.hualala.openapi.sdk.beans.request.crm.QueryUnionIDListBean;
import com.hualala.openapi.sdk.beans.request.equityAccount.QueryProductItemsBean;
import com.hualala.openapi.sdk.beans.request.promotion.QueryUserCouponDetailListBean;
import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.beans.request.shop.DocCreateShopBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.AllotGoodsBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.bill.QueryBillDetailByReportDateRequest;
import com.hualala.openapi.sdk.requests.bill.QueryBillDetailRequest;
import com.hualala.openapi.sdk.requests.crm.QueryUnionIDListRequest;
import com.hualala.openapi.sdk.requests.equityAccount.QueryProductItemsRequest;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import com.hualala.openapi.sdk.requests.promotion.QueryUserCouponDetailListRequest;
import com.hualala.openapi.sdk.requests.report.DataUploadRequest;
import com.hualala.openapi.sdk.requests.shop.DocBaseInfoRequest;
import com.hualala.openapi.sdk.requests.shop.DocCreateShopRequest;
import com.hualala.openapi.sdk.requests.shop.DocOpenFoodRequest;
import com.hualala.openapi.sdk.requests.supplyChain.AllotGoodsRequest;
import com.hualala.openapi.sdk.requests.supplyChain.ExamineVoucherRequest;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailByReportDateResponse;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailResponse;
import com.hualala.openapi.sdk.responses.equityAccount.QueryProductItemsResponse;
import com.hualala.openapi.sdk.responses.order.ThirdOrderResponse;
import com.hualala.openapi.sdk.responses.promotion.QueryUserCouponDetailListResponse;
import com.hualala.openapi.sdk.responses.report.DataUploadResponse;
import com.hualala.openapi.sdk.responses.shop.DocBaseInfoResponse;
import com.hualala.openapi.sdk.responses.shop.DocCreateShopResponse;
import com.hualala.openapi.sdk.responses.shop.DocOpenFoodResponse;
import com.hualala.openapi.sdk.responses.supplyChain.AllotGoodsResponse;
import com.hualala.openapi.sdk.responses.supplyChain.ExamineVoucherResponse;
import com.hualala.openapi.sdk.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class APIHelper implements OpenAPIEngine {

    public DocBaseInfoResponse getDocBaseInfo(Long groupID, Long shopID) {
        DocBaseInfoResponse response = null;

        DocBaseInfoRequest request = new DocBaseInfoRequest();
        request.setGroupID(groupID);
        request.setShopID(shopID);
        DocBaseInfoBean requestBody = new DocBaseInfoBean();
        requestBody.setGroupID(groupID);
//        requestBody.setShopID(shopID);
        request.setRequestBody(requestBody);

        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocBaseInfoResponse.class);
        } catch (Exception e) {
            log.error("getDocBaseInfo 异常. groupID: {} shopID: {}", groupID, shopID, e);
        }

        return response;
    }

    public DocOpenFoodResponse getMenu(Long groupID, Long shopID) {
        DocOpenFoodResponse response = null;

        DocOpenFoodRequest request = new DocOpenFoodRequest();
        request.setGroupID(groupID);
        request.setShopID(shopID);
        DocBaseInfoBean requestBody = new DocBaseInfoBean();
        requestBody.setGroupID(groupID);
        requestBody.setShopID(shopID);
        request.setRequestBody(requestBody);

        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocOpenFoodResponse.class);
        } catch (Exception e) {
            log.error("getMenu 异常. groupID: {} shopID: {}", groupID, shopID, e);
        }

        return response;
    }

    public DocCreateShopResponse createShop(Long groupID, DocCreateShopBean shop) {
        DocCreateShopResponse response = null;

        DocCreateShopRequest request = new DocCreateShopRequest();
        request.setGroupID(groupID);
        request.setRequestBody(shop);

        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocCreateShopResponse.class);
        } catch (Exception e) {
            log.error("getMenu 异常. groupID: {} shopID: {}", groupID, shop, e);
        }

        return response;
    }

    public ThirdOrderResponse thirdOrder(ThirdOrderRequest request) {
        ThirdOrderResponse response = null;
        try {
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ThirdOrderResponse.class);
        } catch (Exception e) {
            log.error("thirdOrder 异常. {}", request, e);
        }

        return response;
    }

    //会员
    public String queryUnionIDs(long groupID, QueryUnionIDListBean bean) {
        try {
            QueryUnionIDListRequest request = new QueryUnionIDListRequest();
            request.setGroupID(groupID);
            request.setRequestBody(bean);
            return WebUtil.post(request);
        } catch (Exception e) {
            log.error("queryUnionIDs 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return null;
    }

    public String queryUserCouponDetailList(QueryUserCouponDetailListBean bean) {
        try {
            QueryUserCouponDetailListRequest request = new QueryUserCouponDetailListRequest();
            request.setGroupID(bean.getGroupID());
            request.setShopID(bean.getShopID());
            request.setRequestBody(bean);

            return WebUtil.post(request);
        } catch (Exception e) {
            log.error("queryUserCouponDetailList 异常. bean: {}",  bean, e);
        }

        return null;
    }

    public ExamineVoucherResponse queryExamineVoucher(long groupID, ExamineVoucherBean bean) {
        ExamineVoucherResponse response = null;
        try {
            ExamineVoucherRequest request = new ExamineVoucherRequest();
            request.setGroupID(groupID);
            request.setRequestBody(bean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ExamineVoucherResponse.class);
        } catch (Exception e) {
            log.error("queryExamineVoucher 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return response;
    }

    public DataUploadResponse dataUpload(long groupID, long shopID, DataUploadBean bean) {
        DataUploadResponse response = null;
        try {
            DataUploadRequest request = new DataUploadRequest();
            request.setGroupID(groupID);
            request.setShopID(shopID);
            request.setRequestBody(bean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DataUploadResponse.class);
        } catch (Exception e) {
            log.error("dataUpload 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return response;
    }

    public QueryBillDetailResponse queryBillDetail(long groupID, long shopID, long reportDate, List<String> saasOrderKeys) {
        QueryBillDetailResponse response = null;
        try {
            QueryBillDetailRequest request = new QueryBillDetailRequest();
            request.setGroupID(groupID);
            request.setShopID(shopID);
            QueryBillDetailBean bean = new QueryBillDetailBean();
            bean.setGroupID(groupID);
            bean.setShopID(shopID);
            bean.setReportDate(reportDate);
            bean.setSaasOrderKeys(saasOrderKeys.stream().collect(Collectors.joining(",")));
            request.setRequestBody(bean);

            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, QueryBillDetailResponse.class);
        } catch (Exception e) {
            log.error("queryBillDetail 异常. groupID: {} shopID: {} date: {} keys: {}", groupID, shopID, reportDate, saasOrderKeys, e);
        }

        return response;
    }

    public QueryBillDetailByReportDateResponse queryBillDetailByReportDate(long groupID, long shopID, long reportDate, int pageNo, int pageSize) {
        QueryBillDetailByReportDateResponse response = null;
        try {
            QueryBillDetailByReportDateRequest request = new QueryBillDetailByReportDateRequest();
            request.setGroupID(groupID);
            request.setShopID(shopID);
            QueryBillDetailByReportDateBean bean = new QueryBillDetailByReportDateBean();
            bean.setGroupID(groupID);
            bean.setShopID(shopID);
            bean.setReportDate(reportDate);
            bean.setPageNo(pageNo);
            bean.setPageSize(pageSize);
            request.setRequestBody(bean);

            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, QueryBillDetailByReportDateResponse.class);
        } catch (Exception e) {
            log.error("queryBillDetailByReportDate 异常. groupID: {} shopID: {} date: {} page: {}-{}", groupID, shopID, reportDate, pageNo, pageSize, e);
        }

        return response;
    }

    public AllotGoodsResponse allotGoods(long groupID, AllotGoodsBean bean) {
        AllotGoodsResponse response = null;
        try {
            AllotGoodsRequest request = new AllotGoodsRequest();
            request.setGroupID(groupID);
            request.setRequestBody(bean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, AllotGoodsResponse.class);
        } catch (Exception e) {
            log.error("allotGoods 异常. groupID: {} bean: {}", groupID, bean, e);
        }

        return response;
    }

    public QueryProductItemsResponse queryProductItemsByProductCategory(long groupID, String source) {
        QueryProductItemsResponse response = null;
        try {
            QueryProductItemsRequest request = new QueryProductItemsRequest();
            request.setGroupID(groupID);
            QueryProductItemsBean bean = new QueryProductItemsBean();
            bean.setSource(source);
            request.setRequestBody(bean);

            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, QueryProductItemsResponse.class);
        } catch (Exception e) {
            log.error("queryProductItemsByProductCategory 异常. groupID: {} source: {}", groupID, source, e);
        }

        return response;
    }

}
