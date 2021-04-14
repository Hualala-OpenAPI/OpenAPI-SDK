package com.hualala.openapi.sdk.requests;

import com.hualala.openapi.sdk.beans.request.DocBaseInfoBean;

public class DocBaseInfoRequest extends BaseRequest<DocBaseInfoBean> {

    public DocBaseInfoRequest() {
        this.setPath("/doc/getBaseInfo");
    }

}
