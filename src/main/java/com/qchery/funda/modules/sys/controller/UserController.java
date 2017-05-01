package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.model.UserModel;
import com.qchery.funda.props.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private SystemProperties systemProperties;

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.WEAK_NET_WORK);
    }

    @RequestMapping("list")
    public Result list() {
        if (systemProperties.getUsers() != null) {
            throw new RuntimeException();
        }
        return new Result(ResultCode.SUCCESS, systemProperties.getUsers());
    }

    @RequestMapping("login")
    public Result login(@RequestBody @Valid UserModel userModel) {
        User existUser = null;
        for (User user : systemProperties.getUsers()) {
            if (user.getUsername().equals(userModel.getUsername())) {
                existUser = user;
            }
        }

        if (existUser == null || !existUser.getPassword().equals(userModel.getPassword())) {
            return new Result(ResultCode.PASSWORD_ERROR);
        }

        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        return new Result(ResultCode.SUCCESS, user);
    }

}
