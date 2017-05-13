package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.model.UserModel;
import com.qchery.funda.modules.sys.service.UserService;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    public static final ThreadLocal<Object> MODEL_HOLDER = new ThreadLocal<>();

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Result list() {
        return ResultUtils.success(userService.listAll());
    }

    @RequestMapping("login")
    public Result login(@RequestBody @Valid UserModel userModel) {
        User user = userService.login(userModel.getUsername(), userModel.getPassword());
        return ResultUtils.success(user);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        MODEL_HOLDER.set(webDataBinder.getTarget());
    }

}
