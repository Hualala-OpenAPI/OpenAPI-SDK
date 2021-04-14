package com.hualala.openapi.sdk.requests;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BaseRequest<T> {
    protected String path = null;
    protected Long groupID = null;
    protected Long shopID = null;
    protected T requestBody = null;

    public boolean valid() {
        return StringUtils.isNotEmpty(path) && null != groupID;
    }
}
