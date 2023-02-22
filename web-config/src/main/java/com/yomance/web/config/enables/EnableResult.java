package com.yomance.web.config.enables;

import com.yomance.web.config.result.BaseExceptionHandler;
import com.yomance.web.config.result.ResultFormatResponseBodyAdvice;
import com.yomance.web.config.result.WebConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启响应结果自动封装
 * @author Yomance
 * @version 1.0
 * @date 2023-01-02 10:18:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({
        ResultFormatResponseBodyAdvice.class,
        WebConfiguration.class,
        BaseExceptionHandler.class
})
public @interface EnableResult {
}
