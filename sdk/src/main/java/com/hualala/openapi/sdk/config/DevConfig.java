package com.hualala.openapi.sdk.config;

import com.hualala.openapi.sdk.consts.SDKConst;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DevConfig {
    @Getter
    private String env = null;
    @Getter
    private String appKey = null;
    @Getter
    private String appSecret = null;

    private DevConfig() {
        super();
    }

    private static DevConfig instance = getInstance();

    public static DevConfig getInstance() {
        if (null == instance) {
            instance = new DevConfig();
            instance.env = getSysProperty(SDKConst.ENV_KEY);
            instance.appKey = getSysProperty(SDKConst.APP_KEY_KEY);
            instance.appSecret = getSysProperty(SDKConst.APP_SECRET_KEY);
        }

        return instance;
    }

    private static String getSysProperty(String key) {
        String value = System.getenv(key);
        if (StringUtils.isNotEmpty(value)) {
            return value;
        } else {
            log.error("OPENAPI SDK缺少应有配置: " + key);
            return null;
        }
    }
}
