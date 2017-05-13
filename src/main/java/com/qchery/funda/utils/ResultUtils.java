package com.qchery.funda.utils;

import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;

/**
 * @author Chery
 * @date 2017/3/25 - 上午12:05
 */
public class ResultUtils {

    public static Result success(Object data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static Result warn(ResultCode resultCode, String msg) {
        Result<Object> result = new Result<>(resultCode);
        result.setMsg(msg);
        return result;
    }

    public static Result warn(ResultCode resultCode) {
        return new Result(resultCode);
    }

}
