package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chery
 * @date 2017/4/30 - 下午10:25
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class FundaErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    @ResponseBody
    public Result doHandleError() {
        return new Result(ResultCode.WEAK_NET_WORK);
    }
}
