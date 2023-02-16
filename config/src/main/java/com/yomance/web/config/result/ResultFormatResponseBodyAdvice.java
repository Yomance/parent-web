package com.yomance.web.config.result;

import com.yomance.web.bean.result.Result;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 此类用于修改接口返回类型 <br />
 *
 * 不生效时添加 确保将本包中的类被扫描到
 * <pre>@SpringBootApplication(scanBasePackageClasses = {ResultFormatResponseBodyAdvice.class})</pre>
 * @author Yomance
 * @version 1.0
 * @date 2022-05-28 9:12:34
 */
@ControllerAdvice
public class ResultFormatResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(@NonNull MethodParameter methodParameter,
                            @NonNull Class converterType) {
        return
                methodParameter.hasMethodAnnotation(ResultFormat.class) ||
                AnnotationUtils.findAnnotation(methodParameter.getContainingClass(), ResultFormat.class) != null;
    }


    @Override
    public Object beforeBodyWrite(
            Object body,
            @NonNull MethodParameter returnType,
            @NonNull MediaType selectedContentType,
            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NonNull ServerHttpRequest request,
            @NonNull ServerHttpResponse response
    ) {
        return body instanceof Result ? body : Result.SUC(body);
    }

}
