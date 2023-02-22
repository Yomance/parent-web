package com.yomance.web.config.enables;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启所有功能
 * @author Yomance
 * @version 1.0
 * @date 2023-01-30 10:26:52
 */
@EnableResult
@UseCorsConfig
@EnablePageQueryBind
@UseJacksonConfig
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAll {
}
