package com.qchery.funda;

import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chery
 * @date 2017/3/28
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doHandleUnknowException() {
        return ResultUtils.warn(ResultCode.WEAK_NET_WORK);
    }

}
