package com.hualala.openapi.sdk.beans.response;

import lombok.Data;

@Data
public class ShopBaseInfoBean {
    private ResultBean result;
    private ShopBaseInfo shopBaseInfo;

    //仅作演示,数据结构不完整
    @Data
    public static class ShopBaseInfo {
        private Long groupID;
        private Long shopID;
        private String shopName;
        private String tel;
    }
}
