package com.test.test_backend.common.utils;

import lombok.Data;


@Data
public class JsonResult<T> {
    private T data;
    private String msg;
    private String code;
    private Boolean success;

    /**
     * 没数据返回时
     */
    public JsonResult() {
        code = "200";
        msg = "操作成功！";
        success = true;
    }

    /**
     * 指定消息与码值
     */
    public JsonResult(String msg, String code, boolean success) {
        this.msg = msg;
        this.code = code;
        success = success;
    }

    /**
     * 单独数据输出
     */
    public JsonResult(T data) {
        this.data = data;
        code = "200";
        msg = "操作成功！";
        success = true;
    }

    /**
     * 有数据输出
     */
    public JsonResult(T data, String msg, String code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
        this.success = true;
    }

    /**
     * 有数据输出
     */
    public JsonResult(T data, String msg, String code, Boolean success) {
        this.data = data;
        this.msg = msg;
        this.code = code;
        this.success = success;
    }
}
