package com.hualala.openapi.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.demo.tool.bill.bean.Bill;
import com.hualala.openapi.demo.tool.bill.bean.BillFood;
import com.hualala.openapi.demo.tool.bill.bean.BillMaster;
import com.hualala.openapi.demo.tool.bill.bean.BillPay;
import com.hualala.openapi.sdk.consts.SDKConst;
import com.hualala.openapi.sdk.consts.SDKEnv;
import com.hualala.openapi.sdk.helper.APIHelper;
import com.hualala.openapi.sdk.intf.OpenAPIEngine;
import com.hualala.openapi.sdk.responses.bill.QueryBillDetailByReportDateResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class QueryBillByReportDateDemo {
    public static void main(String[] args) {
        //修改以下参数
        final long groupID = 0L;
        final long shopID = 0L;
        final long reportDate = 0L;
        // end

        OpenAPIEngine engine = new APIHelper();

        QueryBillDetailByReportDateResponse response = engine.queryBillDetailByReportDate(groupID, shopID, reportDate, 1, 50);
        if ("000".equals(response.getCode())) {
            if (response.getData().containsKey("billDetail")) {
                List<Bill> billList = detail2List(response);

                billList.forEach(bill -> {
                    if (null == bill.getMaster().getChargeBackFlag()) {
                        String remark = bill.getMaster().getOrderRemark();
                        bill.getMaster().setChargeBackFlag(StringUtils.isNotEmpty(remark) && remark.contains("原POS账单") ? 2 : 0);
                    }
                });

                log.info("账单：{}", billList);
            } else {
                log.error("返回数据中未包含账单详情");
            }
        } else {
            log.error("获取账单数据出错 {}", response);
        }
    }

    private static List<Bill> detail2List(QueryBillDetailByReportDateResponse response) {
        JSONArray billDetailList = response.getData().getJSONArray("billDetail");
        List<Bill> billList = new ArrayList<>(billDetailList.size());
        for (Object detail : billDetailList) {
            JSONObject o = (JSONObject) detail;
            try {
                Bill bill = new Bill();
                bill.setMaster(o.toJavaObject(BillMaster.class));
                if (o.containsKey("foodDetail")) {
                    bill.setFoodLst(o.getJSONArray("foodDetail").stream()
                        .map(food -> ((JSONObject) food).toJavaObject(BillFood.class))
                        .collect(Collectors.toList()));
                }

                if (o.containsKey("payDetail")) {
                    bill.setPayLst(o.getJSONArray("payDetail").stream()
                        .map(pay -> ((JSONObject) pay).toJavaObject(BillPay.class))
                        .collect(Collectors.toList()));
                }

                log.info("获取到账单 {}", bill.getMaster().getOrderKey());
                billList.add(bill);
            } catch (Exception e) {
                log.error("处理账单 {} 异常", o.getString("saasOrderKey"), e);
            }
        }

        return billList;
    }

}
