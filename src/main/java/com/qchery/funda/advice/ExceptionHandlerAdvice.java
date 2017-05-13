package com.qchery.funda.advice;

import com.alibaba.fastjson.JSON;
import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.exception.ResultException;
import com.qchery.funda.modules.sys.controller.UserController;
import com.qchery.funda.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Chery
 * @date 2017/5/1 - 下午1:39
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return ResultUtils.warn(ResultCode.PARAMETER_ERROR, tips);
    }

    @ExceptionHandler(ResultException.class)
    public Result handleResultException(ResultException e, HttpServletRequest request) {
        logger.debug("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(UserController.MODEL_HOLDER.get()));
        return ResultUtils.warn(e.getResultCode());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        logger.error("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(UserController.MODEL_HOLDER.get()), e);
        return ResultUtils.warn(ResultCode.WEAK_NET_WORK);
    }

}
