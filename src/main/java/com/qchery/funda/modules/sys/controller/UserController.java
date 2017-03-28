package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.service.UserService;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return ResultUtils.success(userService.login(user));
    }

    @PostMapping("reg")
    public Result register(@RequestBody User user) {
        return ResultUtils.success(userService.save(user));
    }

}
