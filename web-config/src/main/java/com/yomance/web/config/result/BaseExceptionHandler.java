package com.yomance.web.config.result;


import com.yomance.web.bean.result.BusinessException;
import com.yomance.web.bean.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public Object globalExcHandler(BusinessException e) {
        return Result.FAIL(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    public Object f(Throwable e) {
        e.printStackTrace();
        return Result.FAIL(500, e.getMessage());
    }
}
