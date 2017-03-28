package com.qchery.funda.modules.sys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:17
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
