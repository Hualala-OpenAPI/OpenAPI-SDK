package com.hualala.openapi.sdk.utils;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeUtil {

    public static long getTimestamp() {
        Calendar calendar = Calendar.getInstance();
        //东八区
        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        return calendar.getTime().getTime();

    }
}
