package com.hualala.openapi.sdk.controller;

import com.hualala.openapi.sdk.beans.request.order.*;
import com.hualala.openapi.sdk.helper.ResponseFormatter;
import com.hualala.openapi.sdk.requests.order.*;
import com.hualala.openapi.sdk.responses.order.*;
import com.hualala.openapi.sdk.utils.CommonUtil;
import com.hualala.openapi.sdk.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/thirdOrder", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public ThirdOrderResponse thirdOrder(@RequestBody ThirdOrderBean thirdOrderBean) {
        ThirdOrderResponse response = null;
        try {
            ThirdOrderRequest request = new ThirdOrderRequest();
            request.setGroupID(thirdOrderBean.getGroupID());
            request.setShopID(thirdOrderBean.getShopID());
            request.setRequestBody(thirdOrderBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ThirdOrderResponse.class);

        } catch (Exception e) {
            logger.error("thirdOrder 异常 {}", thirdOrderBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/submitordernew", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public ThirdOrderResponse submitordernew(@RequestBody ThirdOrderBean thirdOrderBean) {
        ThirdOrderResponse response = null;
        try {
            SubmitordernewRequest request = new SubmitordernewRequest();
            request.setGroupID(thirdOrderBean.getGroupID());
            request.setShopID(thirdOrderBean.getShopID());
            request.setRequestBody(thirdOrderBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ThirdOrderResponse.class);
        } catch (Exception e) {
            logger.error("submitordernew 异常 {}", thirdOrderBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/payout", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public PayOutResponse payout(@RequestBody WechatPayoutBean wechatPayoutBean) {
        PayOutResponse response = null;
        try {
            WechatPayoutRequest wechatPayoutRequest = new WechatPayoutRequest();
            wechatPayoutRequest.setGroupID(wechatPayoutBean.getGroupID());
            wechatPayoutRequest.setShopID(wechatPayoutBean.getShopID());
            wechatPayoutRequest.setRequestBody(wechatPayoutBean);
            String resp = WebUtil.post(wechatPayoutRequest);
            response = ResponseFormatter.format(resp, PayOutResponse.class);
        } catch (Exception e) {
            logger.error("payout 异常 {}", wechatPayoutBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/senderQueryMsg", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public TableResponse senderQueryMsg(@RequestBody TableBean tableBean) {
        TableResponse response = null;
        try {
            TableRequest tableRequest = new TableRequest();
            tableRequest.setGroupID(tableBean.getGroupID());
            tableRequest.setShopID(tableBean.getShopID());
            tableRequest.setRequestBody(tableBean);
            String resp = WebUtil.post(tableRequest);
            response = ResponseFormatter.format(resp, TableResponse.class);
        } catch (Exception e) {
            logger.error("senderQueryMsg 异常 {}", tableBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/queryTableMsg", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public QueryTableResponse queryTableMsg(@RequestBody QueryTableBean queryTableBean) {
        QueryTableResponse response = null;
        try {
            QueryTableRequest queryTableRequest = new QueryTableRequest();
            queryTableRequest.setGroupID(queryTableBean.getGroupID());
            queryTableRequest.setShopID(queryTableBean.getShopID());
            queryTableRequest.setRequestBody(queryTableBean);
            String resp = WebUtil.post(queryTableRequest);
            response = ResponseFormatter.format(resp, QueryTableResponse.class);
        } catch (Exception e) {
            logger.error("queryTableMsg 异常 {}", queryTableBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/addItems", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public AddItemResponse addItems(@RequestBody AddItemBean addItemBean) {
        AddItemResponse response = null;
        try {
            AddItemRequest request = new AddItemRequest();
            request.setGroupID(addItemBean.getGroupID());
            request.setShopID(addItemBean.getShopID());
            request.setRequestBody(addItemBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, AddItemResponse.class);
        } catch (Exception e) {
            logger.error("addItems 异常 {}", addItemBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/returnFood", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public ReturnFoodResponse returnFood(@RequestBody ReturnFoodBean returnFoodBean) {
        ReturnFoodResponse response = null;
        try {
            ReturnFoodRequest request = new ReturnFoodRequest();
            request.setGroupID(returnFoodBean.getGroupID());
            request.setShopID(returnFoodBean.getShopID());
            request.setRequestBody(returnFoodBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, ReturnFoodResponse.class);
        } catch (Exception e) {
            logger.error("returnFood 异常 {}", ReturnFoodResponse.class, e);
        }
        return response;
    }

    @RequestMapping(value = "/query", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public QueryOrderResponse query(@RequestBody QueryOrderBean queryOrderBean) {
        QueryOrderResponse response = null;
        try {
            QueryOrderRequest request = new QueryOrderRequest();
            request.setGroupID(queryOrderBean.getGroupID());
            request.setShopID(queryOrderBean.getShopID());
            request.setRequestBody(queryOrderBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, QueryOrderResponse.class);
        } catch (Exception e) {
            logger.error("query 异常 {}", QueryOrderResponse.class, e);
        }
        return response;
    }

    @RequestMapping(value = "/updateOrderStatus", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public UpdateOrderStatusResponse updateOrderStatus(@RequestBody UpdateOrderStatusBean updateOrderStatusBean) {
        UpdateOrderStatusResponse response = null;
        try {
            UpdateOrderStatusRequest request = new UpdateOrderStatusRequest();
            request.setGroupID(updateOrderStatusBean.getGroupID());
            request.setShopID(updateOrderStatusBean.getShopID());
            request.setRequestBody(updateOrderStatusBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, UpdateOrderStatusResponse.class);
        } catch (Exception e) {
            logger.error("updateOrderStatus 异常 {}", QueryOrderResponse.class, e);
        }
        return response;
    }

    @RequestMapping(value = "/applyRefund", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public ApplyRefundResponse applyRefund(@RequestBody ApplyRefundBean applyRefundBean) {
        ApplyRefundResponse refundResponse = null;
        try {
            ApplyRefundRequest request = new ApplyRefundRequest();
            request.setGroupID(applyRefundBean.getGroupID());
            request.setShopID(applyRefundBean.getShopID());
            request.setRequestBody(applyRefundBean);
            String resp = WebUtil.post(request);
            refundResponse = ResponseFormatter.format(resp, ApplyRefundResponse.class);
        } catch (Exception e) {
            logger.error("applyRefund 异常 {}", ApplyRefundResponse.class, e);
        }
        return refundResponse;
    }

    @RequestMapping(value = "/createOrder", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public CreateOrderResponse createOrder(@RequestBody CreateOrderBean createOrderBean) {
        logger.info("打印请求参数：{}", createOrderBean);
        CreateOrderResponse createOrderResponse = null;
        try {
            CreateOrderRequest createOrderRequest = new CreateOrderRequest();
            createOrderRequest.setGroupID(createOrderBean.getGroupID());
            createOrderRequest.setShopID(createOrderBean.getShopID());
            createOrderRequest.setRequestBody(createOrderBean);
            String resp = WebUtil.post(createOrderRequest);
            createOrderResponse = ResponseFormatter.format(resp, CreateOrderResponse.class);
        } catch (Exception e) {
            logger.error("createOrder 异常 {}", CreateOrderResponse.class, e);
        }
        return createOrderResponse;
    }
}
