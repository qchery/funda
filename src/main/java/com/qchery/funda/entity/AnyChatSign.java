package com.qchery.funda.entity;

public class AnyChatSign {
    private int timestamp;
    private String sigStr;
    private int errorCode;
    private String appId;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSigStr() {
        return sigStr;
    }

    public void setSigStr(String sigStr) {
        this.sigStr = sigStr;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
