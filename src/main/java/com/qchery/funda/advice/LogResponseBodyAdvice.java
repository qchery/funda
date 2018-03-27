package com.qchery.funda.advice;

import com.qchery.funda.utils.JsonDesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chery
 * @date 2017/5/2 - 下午10:45
 */
@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(LogResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (logger.isDebugEnabled()) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            String requestUriWithoutContextPath = servletRequest.getRequestURI().substring(servletRequest.getContextPath().length());
            logger.debug("uri={} | responseBody={}", requestUriWithoutContextPath, JsonDesUtils.toLogString(body));
        }
        return body;
    }
}
