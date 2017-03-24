package com.qchery.funda.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:19
 */
@ConfigurationProperties
@Component
public class AnychatProperties {

    /**
     * 应用 ID
     */
    @Value("${anychat.app.id}")
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
