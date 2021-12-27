package com.hualala.openapi.sdk.beans.request;

import lombok.Data;

@Data
public class HeaderBean {
    private String traceID;

    public HeaderBean() {
        super();
    }

    public HeaderBean(String traceID) {
        this.traceID = traceID;
    }
}
