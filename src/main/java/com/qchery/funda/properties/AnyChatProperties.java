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
public class AnyChatProperties {

    @Value("${anychat.private.key.path}")
    private String privateKeyPath;

    @Value("${anychat.public.key.path}")
    private String publicKeyPath;

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath;
    }
}
