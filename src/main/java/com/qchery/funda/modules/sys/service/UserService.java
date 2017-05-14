package com.qchery.funda.modules.sys.service;

import com.qchery.funda.enums.ResultCode;
import com.qchery.funda.exception.ResultException;
import com.qchery.funda.modules.sys.dao.UserDao;
import com.qchery.funda.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:52
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(String username, String password) {
        User existUser = userDao.findByUsername(username);
        if (existUser == null || !existUser.getPassword().equals(password)) {
            throw new ResultException(ResultCode.PASSWORD_ERROR);
        }
        return existUser;
    }

    public List<User> listAll() {
        return userDao.findAll();
    }

    public List<User> listByAgeLargeThan(int age) {
        return userDao.findByAgeLargeThan(age);
    }

}
