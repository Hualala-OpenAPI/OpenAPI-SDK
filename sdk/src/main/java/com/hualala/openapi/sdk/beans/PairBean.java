package com.hualala.openapi.sdk.beans;

import lombok.Data;

@Data
public class PairBean<T> {
    private String key;
    private T value;

    public PairBean(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
