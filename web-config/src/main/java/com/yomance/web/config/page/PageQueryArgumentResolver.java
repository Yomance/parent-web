package com.yomance.web.config.page;


import com.yomance.web.bean.page.PageQuery;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;


/**
 * 在GET请求中为PageQuery绑定Where参数 <br />
 * 例如：
 * <pre>GET https://a.com/page?current=1&size=2&desc=true</pre>
 * 会解析成为
 * <pre>
 *  PageQuery = {
 *      current: 1,
 *      size: 2,
 *      where:{
 *          desc: true
 *      }
 *  }</pre>
 */
public class PageQueryArgumentResolver implements HandlerMethodArgumentResolver {

    //判断是否支持要转换的参数类型
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(PageQuery.class);
    }

    //当支持后进行相应的转换
    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        Map<String, String[]> map = webRequest.getParameterMap();
        PageQuery<Object> pageQuery = new PageQuery<>();
        // 设置current
        String[] currents = map.get("current");
        if (currents != null && currents.length > 0) {
            pageQuery.setCurrent(Integer.parseInt(currents[0]));
        }
        // 设置size
        String[] sizes = map.get("size");
        if (sizes != null && sizes.length > 0) {
            pageQuery.setSize(Integer.parseInt(sizes[0]));
        }

        Object where = getWhereObject(parameter.getGenericParameterType());
        if (where != null) {
            // 绑定where的值
            WebDataBinder binder = binderFactory.createBinder(webRequest, where, "Where");
            MutablePropertyValues v = new MutablePropertyValues(map);
            binder.bind(v);
        }

        // 设置where
        pageQuery.setWhere(where);
        return pageQuery;
    }


    @Nullable
    private Object getWhereObject(Type type) {
        try {
            if (type instanceof ParameterizedType) {
                Type argument = ((ParameterizedType) type).getActualTypeArguments()[0];
                Class<?> T;
                if (argument instanceof Class) {
                    T = (Class<?>) argument;
                } else {
                    if (argument.getTypeName().equals("?")) return null;
                    T = Class.forName(argument.getTypeName());
                }
                return T.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}