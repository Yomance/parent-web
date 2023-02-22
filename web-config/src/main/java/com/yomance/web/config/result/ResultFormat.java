package com.yomance.web.config.result;

import java.lang.annotation.*;

/**
 * 对响应结果进行包装
 * @author Yomance
 * @version 1.0
 * @date 2022-05-08 7:31:33
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResultFormat {
}
