package com.qchery.funda.modules.sys.model;

import com.qchery.funda.validator.Phone;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Chery
 * @date 2017/4/26 - 下午9:45
 */
public class UserModel {

    private String username;
    private String password;
    private int age;

    @NotBlank(message = "用户名不能为空")
    @Phone
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "密码不能为空")
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
}
