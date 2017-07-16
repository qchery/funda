package com.qchery.funda.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qchery.funda.utils.annotation.JsonDes;

import javax.validation.constraints.Min;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:17
 */
public class User {

    private Long id;

    private String username;

    private String password;

    @Min(20)
    private int age;
    private String nickName;
    /**
     * 证件号
     */
    @JsonDes
    private String certId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }
}
