package com.test.test_backend.common.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {
    SUCCESS("success", "200"),
    FILED("filed", "400"),
    NOT_FOUND("not found", "404");
    private final String name;
    private final String code;

    CodeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
