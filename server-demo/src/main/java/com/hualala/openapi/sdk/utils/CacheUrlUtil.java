package com.hualala.openapi.sdk.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheUrlUtil {
    public static List<String> cacheUrl = null;

    @PostConstruct//优先执行
    public static void init() {
        cacheUrl = new ArrayList<>();
        cacheUrl.add("/doc/getBaseInfo");
        cacheUrl.add("/doc/getOpenFood");
        cacheUrl.add("/order/thirdOrder");
        cacheUrl.add("/order/submitordernew");
        cacheUrl.add("/order/payout");
        cacheUrl.add("/report/getBillShopDayDetailBySaasOrderKey");
        cacheUrl.add("/v2/supplyChain/allotGoods");
        cacheUrl.add("/order/senderQueryMsg");
        cacheUrl.add("/order/queryTableMsg");
        cacheUrl.add("/inventory/getAvailableFoodRemainQtyByShopID");
        cacheUrl.add("/order/addItems");
        cacheUrl.add("/order/returnFood");
        cacheUrl.add("/doc/getPaySubject");
        cacheUrl.add("/order/query");
        cacheUrl.add("/order/updateOrderStatus");
        cacheUrl.add("/order/applyRefund");
        cacheUrl.add("/order/createOrder");
    }

    @PreDestroy
    public void destory() {

    }

    public boolean isExistUrl(String url) {
        return cacheUrl.contains(url);
    }
}
   
    