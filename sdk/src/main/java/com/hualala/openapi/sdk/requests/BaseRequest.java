package com.hualala.openapi.sdk.requests;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class BaseRequest<T> {
    @Getter
    private String path;
    @Getter
    @Setter
    protected Long groupID = null;
    @Getter
    @Setter
    protected Long shopID = null;
    @Getter
    @Setter
    protected T requestBody = null;

    public boolean valid() {
        return StringUtils.isNotEmpty(path) && null != groupID;
    }

    public BaseRequest(String path) {
        this.path = path;
    }

    public BaseRequest() {
        throw new RuntimeException("需要给参数[path]赋值");
    }
}
