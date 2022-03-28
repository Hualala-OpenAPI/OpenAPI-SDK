package com.hualala.openapi.sdk.consts;

/**
 * @ Description：公共变量枚举
 */
public enum ConstantsEnum {
    SUCCESS(000, "成功"),
    NUKNOWN_ERROR(1, "未知错误"),
    SERVICE_TEMPORARILY_UNAVAILABLE(2, "服务暂不可用"),
    INSUFFICIENT_PERMISSIONS(3, "权限不足");

    private final int value;
    private final String reasonPhrase;

    ConstantsEnum(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public static ConstantsEnum valueOf(int code) {
        for (ConstantsEnum ce : values()) {
            if (ce.value == code) {
                return ce;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
