package com.yomance.web.config.result;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 解决ResponseBodyAdvice处理公共返回值时返回String类型的报错
 * @see <a href="https://blog.csdn.net/qq_37170583/article/details/107470337">链接</a>
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 第一种方式是将 json 处理的转换器放到第一位，使得先让 json 转换器处理返回值，这样 String转换器就处理不了了。
        // converters.add(0, new MappingJackson2HttpMessageConverter());
        // 第二种就是把String类型的转换器去掉，不使用String类型的转换器
        converters.removeIf(httpMessageConverter ->
                httpMessageConverter.getClass() == StringHttpMessageConverter.class);
    }
}
