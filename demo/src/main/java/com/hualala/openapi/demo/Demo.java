package com.hualala.openapi.demo;

import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.AllotGoodsBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.helper.APIHelper;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.requests.order.ThirdOrderRequest;
import com.hualala.openapi.sdk.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Demo {
    private static final OpenAPIEngine ENGINE = new APIHelper();

    public static void main(String[] arg) {
//        testDecode();

        testGetAllShops();
//        testOnline();
//        testOrderDev();
//        testDataUpload();
//        testAllotGoods();
//        testGetMenu();
    }

    private static void testDecode() {
        String appSecret = null;
        String ciphertext = null;
        String plaintext = SignUtil.AESDecode(appSecret, ciphertext);
        if (StringUtils.isNotEmpty(plaintext)) {
            log.info("\n***\n*解密结果:\n{}\n*appSecret:{}\n*密文:{}\n***\n", plaintext, appSecret, ciphertext);
        } else {
            log.error("\n***\n*解密失败\n*appSecret:{}\n*密文:{}\n***\n", appSecret, ciphertext);
        }
    }

    private static void testDev() {
        OpenAPIEngine engine = new APIHelper();
        System.out.println(JSONObject.toJSONString(engine.getDocBaseInfo(1155L, 76068673L)));
    }

    private static void testGetAllShops() {
        System.out.println(ENGINE.getDocAllShops(282976));
    }

    private static void testOrderDev() {
        OpenAPIEngine engine = new APIHelper();
        ThirdOrderRequest request = new ThirdOrderRequest();
        //todo init request
        System.out.println(JSONObject.toJSONString(engine.thirdOrder(request)));
    }

    private static void testOnline() {
        OpenAPIEngine engine = new APIHelper();
        ExamineVoucherBean bean = JSONObject.parseObject("", ExamineVoucherBean.class);
        System.out.println(JSONObject.toJSONString(engine.queryExamineVoucher(0L, bean)));
    }

    private static void testDataUpload() {
        OpenAPIEngine engine = new APIHelper();

        long groupID = 0L, shopID = 0L;
        DataUploadBean bean = new DataUploadBean();
        bean.setGroupID(groupID);
        bean.setBusiness("评价");
        bean.setPk("");
        bean.setDatals("");

        System.out.println(JSONObject.toJSONString(engine.dataUpload(groupID, shopID, bean)));
    }

    private static void testAllotGoods() {
        OpenAPIEngine engine = new APIHelper();

        AllotGoodsBean bean = JSONObject.parseObject("", AllotGoodsBean.class);
        System.out.println(JSONObject.toJSONString(engine.allotGoods(0L, bean)));
    }

    private static void testGetMenu() {
        OpenAPIEngine engine = new APIHelper();
        System.out.println(JSONObject.toJSONString(engine.getMenu(1155L, 76068673L)));
    }
}
