package com.qchery.funda.controller;

import com.qchery.funda.Result;
import com.qchery.funda.properties.AnychatProperties;
import com.qchery.funda.service.UserService;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:17
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnychatProperties anychatProperties;

    @PostMapping("login")
    public Result login() {
        return ResultUtils.success(userService.login());
    }

    @GetMapping("sign")
    public Result sign() {
        return ResultUtils.success(anychatProperties.getAppId());
    }

}
