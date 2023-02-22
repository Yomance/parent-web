package com.yomance.web.bean.result;


import java.io.Serializable;

/**
 * @author Yomance
 * @version 1.0
 * @date 2022-02-02 20:08:55
 */

public class Result<T> implements Serializable {
    private static final int SUN_CODE = 0;
    private static final String SUC_TEXT = "成功";
    private static final String FAIL_TEXT = "服务器错误";

    private static final Result<Object> suc = new Result<>(SUN_CODE, SUC_TEXT, null);
    private static final Result<Object> fail = new Result<>(Constants.DEFAULT_CODE, FAIL_TEXT, null);
    private final Integer code;
    private final String message;
    private final T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result<?> SUC() {
        return suc;
    }

    public static <T> Result<T> SUC(T data) {
        return new Result<>(SUN_CODE, SUC_TEXT, data);
    }

    public static Result<?> FAIL() {
        return fail;
    }

    public static Result<?> FAIL(String msg) {
        return FAIL(Constants.DEFAULT_CODE, msg);
    }

    public static Result<?> FAIL(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "{"
                + "\"code\":"
                + code
                + ",\"message\":\""
                + message + '\"'
                + ",\"data\":"
                + data.toString()
                + "}";
    }
}
