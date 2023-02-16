package com.yomance.web.config.page;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class PageQueryArgumentResolverMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册PageQueryArgumentResolver的参数分解器
        argumentResolvers.add(new PageQueryArgumentResolver());
    }
}