package com.hualala.openapi.sdk.requests.report;

import com.hualala.openapi.sdk.beans.request.report.DataUploadBean;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class DataUploadRequest extends BaseRequest<DataUploadBean> {

    public DataUploadRequest() {
        this.path = "/report/data/upload";
    }

}
