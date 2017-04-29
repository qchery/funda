package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.modules.sys.model.UserModel;
import com.qchery.funda.modules.sys.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    @RequestMapping("login")
    public Result login(@RequestBody @Valid UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        return new Result(ResultCode.SUCCESS, user);
    }

}
