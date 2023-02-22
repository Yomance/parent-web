package com.yomance.web.config.enables;

import com.yomance.web.config.cors.CorsConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启跨域配置
 * @author Yomance
 * @version 1.0
 * @date 2023-01-30 17:03:53
 */
@Import(CorsConfig.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCorsConfig {
}
