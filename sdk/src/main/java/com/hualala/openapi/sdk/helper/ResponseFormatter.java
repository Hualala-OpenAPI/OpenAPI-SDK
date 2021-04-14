package com.hualala.openapi.sdk.helper;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

public class ResponseFormatter {

    public static <T> T format(String response, Class<T> clz) {
        try {
            TypeReference<T> tr = new TypeReference<T>() {
                @Override
                public Type getType() {
                    return clz;
                }
            };

            return JSONObject.parseObject(response, tr.getType());
        } catch (Exception e) {
            return null;
        }
    }

}
