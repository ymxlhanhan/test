package com.test.test_backend.common.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {
    SUCCESS("success", "200", true),
    FILED("filed", "400", false),
    NOT_FOUND("not found", "404", false);

    private final String msg;
    private final String code;
    private final Boolean state;

    CodeEnum(String msg, String code, Boolean state) {
        this.msg = msg;
        this.code = code;
        this.state = state;
    }
}
