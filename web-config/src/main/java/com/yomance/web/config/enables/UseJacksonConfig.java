package com.yomance.web.config.enables;

import com.yomance.web.config.jackson.JacksonObjectMapperConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yomance
 * @version 1.0
 * @date 2023-02-16 21:59:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(JacksonObjectMapperConfig.class)
public @interface UseJacksonConfig {
}
