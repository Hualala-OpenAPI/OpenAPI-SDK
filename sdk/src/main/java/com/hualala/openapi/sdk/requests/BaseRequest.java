package com.hualala.openapi.sdk.requests;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class BaseRequest<T> {
    @Getter
    protected String path = null;
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
}
