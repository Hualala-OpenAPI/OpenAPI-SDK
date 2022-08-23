package com.hualala.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.beans.request.shop.DocCreateShopBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.AllotGoodsBean;
import com.hualala.openapi.sdk.beans.request.supplyChain.ExamineVoucherBean;
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
//        testDev();

//        testGetAllShops();
//        testOnline();
//        testOrderDev();
//        testDataUpload();
//        testAllotGoods();
//        testGetMenu();
        testCreateShop();
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
        System.out.println(JSONObject.toJSONString(ENGINE.getDocBaseInfo(1155L, 76068673L)));
    }

    private static void testGetAllShops() {
        System.out.println(ENGINE.getDocAllShops(282976));
    }

    private static void testOrderDev() {
        ThirdOrderRequest request = new ThirdOrderRequest();
        //todo init request
        System.out.println(JSONObject.toJSONString(ENGINE.thirdOrder(request)));
    }

    private static void testOnline() {
        ExamineVoucherBean bean = JSONObject.parseObject("", ExamineVoucherBean.class);
        System.out.println(JSONObject.toJSONString(ENGINE.queryExamineVoucher(0L, bean)));
    }

    private static void testDataUpload() {
        long groupID = 0L, shopID = 0L;
        DataUploadBean bean = new DataUploadBean();
        bean.setGroupID(groupID);
        bean.setBusiness("评价");
        bean.setPk("");
        bean.setDatals("");

        System.out.println(JSONObject.toJSONString(ENGINE.dataUpload(groupID, shopID, bean)));
    }

    private static void testAllotGoods() {
        AllotGoodsBean bean = JSONObject.parseObject("", AllotGoodsBean.class);
        System.out.println(JSONObject.toJSONString(ENGINE.allotGoods(0L, bean)));
    }

    private static void testGetMenu() {
        System.out.println(JSONObject.toJSONString(ENGINE.getMenu(1155L, 76068673L)));
    }

    private static void testCreateShop() {
        DocCreateShopBean bean = JSON.parseObject("", DocCreateShopBean.class);

        System.out.println(ENGINE.createShop(bean.getGroupID().longValue(), bean));
    }
}
