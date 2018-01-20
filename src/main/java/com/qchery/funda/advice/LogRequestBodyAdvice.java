package com.qchery.funda.advice;

import com.qchery.funda.utils.JsonDesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author Chery
 * @date 2017/5/2 - 下午9:48
 */
@ControllerAdvice
public class LogRequestBodyAdvice implements RequestBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(LogRequestBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage,
                                  MethodParameter parameter, Type targetType,
                                  Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage,
                                           MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = parameter.getMethod();
        String classMappingUri = getClassMappingUri(method.getDeclaringClass());
        String methodMappingUri = getMethodMappingUri(method);
        if (!methodMappingUri.startsWith("/")) {
            methodMappingUri = "/" + methodMappingUri;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("uri={} | requestBody={}", classMappingUri + methodMappingUri, JsonDesUtils.toLogString(body));
        }
        return body;
    }

    private String getMethodMappingUri(Method method) {
        RequestMapping methodDeclaredAnnotation = method.getDeclaredAnnotation(RequestMapping.class);
        return methodDeclaredAnnotation == null ? "" : getMaxLength(methodDeclaredAnnotation.value());
    }

    private String getClassMappingUri(Class<?> declaringClass) {
        RequestMapping classDeclaredAnnotation = declaringClass.getDeclaredAnnotation(RequestMapping.class);
        return classDeclaredAnnotation == null ? "" : getMaxLength(classDeclaredAnnotation.value());
    }

    private String getMaxLength(String[] strings) {
        String methodMappingUri = "";
        for (String string : strings) {
            if (string.length() > methodMappingUri.length()) {
                methodMappingUri = string;
            }
        }
        return methodMappingUri;
    }
}
