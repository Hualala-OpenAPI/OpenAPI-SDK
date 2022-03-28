package com.hualala.openapi.sdk.controller;

import com.hualala.openapi.sdk.beans.request.shop.DocBaseInfoBean;
import com.hualala.openapi.sdk.helper.ResponseFormatter;
import com.hualala.openapi.sdk.requests.shop.DocOpenFoodRequest;
import com.hualala.openapi.sdk.requests.shop.DocPaySubjectRequest;
import com.hualala.openapi.sdk.responses.shop.DocOpenFoodResponse;
import com.hualala.openapi.sdk.responses.shop.DocPaySubjectResponse;
import com.hualala.openapi.sdk.utils.CommonUtil;
import com.hualala.openapi.sdk.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Description：基本档
 */
@RestController
@RequestMapping("/doc")
public class DocumentController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getOpenFood", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public DocOpenFoodResponse getOpenFood(@RequestBody DocBaseInfoBean docBaseInfoBean) {
        DocOpenFoodResponse response = null;
        try {
            DocOpenFoodRequest request = new DocOpenFoodRequest();
            request.setGroupID(docBaseInfoBean.getGroupID());
            request.setShopID(docBaseInfoBean.getShopID());
            request.setRequestBody(docBaseInfoBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocOpenFoodResponse.class);
        } catch (Exception e) {
            logger.error("getOpenFood 异常 {}", docBaseInfoBean, e);
        }
        return response;
    }

    @RequestMapping(value = "/getPaySubject", produces = CommonUtil.JSON_PROTOCOL, method = RequestMethod.POST)
    public DocPaySubjectResponse getPaySubject(@RequestBody DocBaseInfoBean docBaseInfoBean) {
        DocPaySubjectResponse response = null;
        try {
            DocPaySubjectRequest request = new DocPaySubjectRequest();
            request.setGroupID(docBaseInfoBean.getGroupID());
            request.setShopID(docBaseInfoBean.getShopID());
            request.setRequestBody(docBaseInfoBean);
            String resp = WebUtil.post(request);
            response = ResponseFormatter.format(resp, DocPaySubjectResponse.class);
        } catch (Exception e) {
            logger.error("getPaySubject 异常 {}", docBaseInfoBean, e);
        }
        return response;
    }

}
   
    