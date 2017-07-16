package com.qchery.funda.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.model.UserModel;
import com.qchery.funda.modules.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Chery
 * @date 2017/4/29 - 下午1:37
 */
@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void list() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1000L);
        user.setAge(22);
        user.setUsername("13632674444");
        user.setNickName("小芳");
        user.setCertId("140423199905011117");
        users.add(user);

        given(this.userService.listByAgeLargeThan(20)).willReturn(users);
        UserModel userModel = new UserModel();
        userModel.setAge(20);
        mockMvc.perform(post("/sys/user/list").content(JSON.toJSONString(userModel))
                .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.code").value(ResultCode.SUCCESS.getCode()));
    }

    @Test
    public void login() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUsername("13632675555");
        userModel.setPassword("123");

        User user = new User();
        user.setId(1000L);
        user.setAge(18);
        user.setUsername("13632674444");
        user.setNickName("小芳");
        given(this.userService.login(userModel.getUsername(), userModel.getPassword())).willReturn(user);

        mockMvc.perform(post("/sys/user/login").content(JSON.toJSONString(userModel))
                .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.code").value(ResultCode.SUCCESS.getCode()));
    }

}