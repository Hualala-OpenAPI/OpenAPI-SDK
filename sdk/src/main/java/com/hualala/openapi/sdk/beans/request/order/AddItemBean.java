package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class AddItemBean extends BaseBean {
    private String orderKey;
    private List<WechatOrderItemBean> items;
}
   
    