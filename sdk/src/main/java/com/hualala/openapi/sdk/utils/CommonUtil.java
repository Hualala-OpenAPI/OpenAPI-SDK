package com.hualala.openapi.sdk.utils;

import java.util.UUID;

public class CommonUtil {

    public static String getTraceID() {
        return UUID.randomUUID().toString();
    }

}
