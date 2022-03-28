package com.hualala.openapi.sdk.controller;

import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.helper.ResponseFormatter;
import com.hualala.openapi.sdk.requests.shop.DocAvailableFoodRequest;
import com.hualala.openapi.sdk.responses.shop.DocAvailableFoodResponse;
import com.hualala.openapi.sdk.utils.CommonUtil;
import com.hualala.openapi.sdk.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Description：沽清
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getAvailableFoodRemainQtyByShopID", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public DocAvailableFoodResponse submitordernew(@RequestBody DocBaseInfoBean docBaseInfoBean) {
        DocAvailableFoodResponse response = null;
        try {
            DocAvailableFoodRequest request = new DocAvailableFoodRequest();
            request.setGroupID(docBaseInfoBean.getGroupID());
            request.setShopID(docBaseInfoBean.getShopID());
            request.setRequestBody(docBaseInfoBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocAvailableFoodResponse.class);
        } catch (Exception e) {
            logger.error("getAvailableFoodRemainQtyByShopID 异常 {}", docBaseInfoBean, e);
        }
        return response;
    }
}
   
    