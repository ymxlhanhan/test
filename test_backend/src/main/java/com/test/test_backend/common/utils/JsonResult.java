package com.test.test_backend.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.test.test_backend.common.enums.CodeEnum.FILED;
import static com.test.test_backend.common.enums.CodeEnum.SUCCESS;


@Data
@AllArgsConstructor
public class JsonResult<T> {
    private T data;
    private String msg;
    private String code;
    private Boolean status;

    public String toJsonString() {
        StringBuffer jsonString = new StringBuffer();
        jsonString.append("{\n");
        jsonString.append("\t\"data\":\"").append(this.data).append("\",\n");
        jsonString.append("\t\"msg\":\"").append(this.msg).append("\",\n");
        jsonString.append("\t\"code\":\"").append(this.code).append("\",\n");
        jsonString.append("\t\"status\":\"").append(this.status).append("\n");
        jsonString.append("}");
        return jsonString.toString();
    }

    /**
     * 无参成功
     */
    public static <T> JsonResult<T> success() {
        return new JsonResult<T>(null, SUCCESS.getMsg(), SUCCESS.getCode(), SUCCESS.getState());
    }

    /**
     * 有参成功
     */
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(data, SUCCESS.getMsg(), SUCCESS.getCode(), SUCCESS.getState());
    }

    /**
     * 自定义成功消息
     */
    public static <T> JsonResult<T> success(T data, String msg) {
        return new JsonResult<T>(data, msg, SUCCESS.getCode(), SUCCESS.getState());
    }

    /**
     * 失败
     */
    public static <T> JsonResult<T> fail() {
        return new JsonResult<T>(null, FILED.getMsg(), FILED.getCode(), FILED.getState());
    }

    /**
     * 自定义失败消息
     */
    public static <T> JsonResult<T> fail(String msg) {
        return new JsonResult<T>(null, msg, FILED.getCode(), FILED.getState());
    }

    /**
     * 自定义失败消息
     */
    public static <T> JsonResult<T> fail(String msg, String code) {
        return new JsonResult<T>(null, msg, code, FILED.getState());
    }
}
