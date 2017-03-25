package com.qchery.funda.model;

import com.qchery.funda.entity.AnyChatSign;

/**
 * @author Chery
 * @date 2017/3/25 - 下午10:12
 */
public class AnyChatSignModel extends AnyChatSign {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 应用 ID
     */
    private String appid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
