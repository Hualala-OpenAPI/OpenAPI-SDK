package com.hualala.openapi.sdk.beans.request.crm;

import com.hualala.openapi.sdk.beans.request.HeaderBean;
import lombok.Data;

@Data
public class QueryUnionIDListBean {
    private HeaderBean header;
    private String groupID;
    private String appID;
    private String offset;
}
