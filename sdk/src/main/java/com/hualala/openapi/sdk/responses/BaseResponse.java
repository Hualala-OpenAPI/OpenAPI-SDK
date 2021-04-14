package com.hualala.openapi.sdk.responses;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code = "111";
    private T data;
    private String message;
    private String traceID;

    public void copy(BaseResponse bean) {
        if (null != bean) {
            this.code = bean.code;
            this.message = bean.message;
            this.traceID = bean.traceID;
        }
    }

}
