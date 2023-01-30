package com.hualala.openapi.sdk.requests.test;

import com.alibaba.fastjson.JSONObject;
import com.hualala.openapi.sdk.requests.BaseRequest;

public class TestRequest extends BaseRequest<JSONObject> {

    public TestRequest(String path) {
        super(path);
    }

}
