package com.yomance.web.config.enables;

import com.yomance.web.config.page.PageQueryArgumentResolverMvcConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启PageQuery参数注入
 * @author Yomance
 * @version 1.0
 * @date 2023-01-30 10:25:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(PageQueryArgumentResolverMvcConfiguration.class)
public @interface EnablePageQueryBind {
}
