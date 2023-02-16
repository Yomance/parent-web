package com.yomance.web.bean.result;


/**
 * 通用业务异常
 *
 * @author Yomance
 * @version 1.0
 * @date 2022-05-12 9:23:32
 */
public class BusinessException extends RuntimeException implements ErrorStatus {

    private final int code;

    public BusinessException(ErrorStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }

    public BusinessException(String msg) {
        super(msg);
        this.code = Constants.DEFAULT_CODE;
    }

    public static void exc(String msg, boolean isErr) {
        if (isErr) throw new BusinessException(msg);
    }

    @Override
    public int getCode() {
        return code;
    }
}
