package com.qchery.funda.service;

import com.qchery.funda.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:52
 */
@Service
public class UserService {

    public User login() {
        User user = new User();
        user.setUsername("Emmu Thusi");
        user.setPassword("123456");
        return user;
    }

}
