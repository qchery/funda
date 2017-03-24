package com.qchery.funda.enums;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:23
 */
public enum  ResultCode {

    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
