package com.hualala.openapi.sdk.utils;

import com.hualala.openapi.sdk.consts.SDKConst;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class CommonUtil {

    public static String getTraceID() {
        return UUID.randomUUID().toString().replaceAll(SDKConst.SEPARATOR_MINUS, StringUtils.EMPTY).toLowerCase();
    }

}
