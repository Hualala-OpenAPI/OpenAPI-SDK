package com.hualala.openapi.sdk.beans.response;

import lombok.Data;

@Data
public class ResultBean {
    private String code;
    private String message;
    private String traceID;
}
