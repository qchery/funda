package com.qchery.funda.modules.sys.service;

import com.qchery.funda.exception.ResultException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chery
 * @date 2017/5/6 - 下午2:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test(expected = ResultException.class)
    public void login() throws Exception {
        Assert.assertNotNull(userService.login("13632675555", "123456"));
        userService.login("13632675555", "123457");
    }

    @Test
    public void listAll() throws Exception {
        Assert.assertEquals(2, userService.listAll().size());
    }

}