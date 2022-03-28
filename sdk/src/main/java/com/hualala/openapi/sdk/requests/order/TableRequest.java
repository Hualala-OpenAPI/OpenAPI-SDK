package com.hualala.openapi.sdk.requests.order;

import com.hualala.openapi.sdk.beans.request.order.TableBean;
import com.hualala.openapi.sdk.requests.BaseRequest;
import lombok.Data;

@Data
public class TableRequest extends BaseRequest<TableBean> {
    public TableRequest() {
        this.path = "/order/senderQueryMsg";
    }
}
   
    