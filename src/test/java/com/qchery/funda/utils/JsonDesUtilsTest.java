package com.qchery.funda.utils;

import com.qchery.funda.modules.sys.entity.User;
import org.junit.Test;

/**
 * @author Chery
 * @date 2017/7/16 - 下午2:18
 */
public class JsonDesUtilsTest {

    @Test
    public void toLogString() throws Exception {
        User user = new User();
        user.setId(1000L);
        user.setAge(22);
        user.setUsername("13632674444");
        user.setNickName("小芳");
        user.setCertId("140423199905011117");
        System.out.println(JsonDesUtils.toLogString(user));
    }

}