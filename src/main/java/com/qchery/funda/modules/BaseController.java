package com.qchery.funda.modules;

import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Chery
 * @date 2017/5/1 - 下午1:26
 */
public class BaseController {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.WEAK_NET_WORK);
    }

}
