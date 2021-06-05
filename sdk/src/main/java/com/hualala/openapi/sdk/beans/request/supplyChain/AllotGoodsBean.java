package com.hualala.openapi.sdk.beans.request.supplyChain;

import lombok.Data;

@Data
public class AllotGoodsBean {
    private String action;
    private String actionBy;
    private String demandCode;
    private GoodInfo goodsInfo;
    private long groupID;
    private String traceID;

    @Data
    public static class GoodInfo {
        private String goodsCode;
        private String isOrdered;
        private String shopUnit;
    }
}
