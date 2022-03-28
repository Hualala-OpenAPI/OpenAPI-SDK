package com.hualala.openapi.sdk.beans.response;

import lombok.Data;

@Data
public class ResultBean<T> implements java.io.Serializable {
    private static final long serialVersionUID = 3297958103132517141L;
    private String code;
    private String message;
    private String traceID;

    public ResultBean(String code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
