package com.yomance.web.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        // 设置允许跨域请求的域名
        // 是否允许证书（cookies）
        // 设置允许的方法
        // 跨域允许时间
        registry
                .addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(false)
                .allowedMethods("*")
                .maxAge(3600);
    }
}