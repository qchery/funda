package com.qchery.funda.utils;

import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.utils.annotation.JsonDes;
import org.junit.Test;

/**
 * @author Chery
 * @date 2017/7/16 - 下午2:18
 */
public class JsonDesUtilsTest {

    @Test
    public void toLogString() throws Exception {
        SubUser user = new SubUser();
        user.setId(1000L);
        user.setAge(22);
        user.setUsername("13632674444");
        user.setNickName("小芳");
        user.setCertId("140423199905011117");
        user.setBankCardNo("38493839102947859834");
        System.out.println(JsonDesUtils.toLogString(user));
    }

    private class SubUser extends User {
        @JsonDes(prefixLength = 4)
        private String bankCardNo;

        public String getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(String bankCardNo) {
            this.bankCardNo = bankCardNo;
        }
    }

}