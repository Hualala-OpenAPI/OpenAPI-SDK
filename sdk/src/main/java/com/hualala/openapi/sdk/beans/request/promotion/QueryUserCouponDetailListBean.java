package com.hualala.openapi.sdk.beans.request.promotion;

import com.hualala.openapi.sdk.beans.request.HeaderBean;
import lombok.Data;

import java.util.List;

@Data
public class QueryUserCouponDetailListBean {
    private HeaderBean header;

    private Long groupID;
    private Long subGroupID;
    private Long shopID;

    private Long customerID;

    private Long giftItermID;
    private String giftPWD;
    private Integer giftStatus;
    private List<Integer> giftTypes;

    private Boolean isIncludeIneffective;
    private Boolean isNeedCouponShare;
    private Boolean isNeedShopInfo;
    private Boolean isWechatQuery;
    private Boolean sourceWay;
    private List<String> brandIDs;
    private String applyScene;
}
