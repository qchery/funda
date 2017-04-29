//package com.qchery.funda.modules.sys.service;
//
//import com.qchery.funda.modules.sys.dao.UserRespository;
//import com.qchery.funda.modules.sys.entity.User;
//import com.qchery.funda.enums.ResultCode;
//import com.qchery.funda.exception.ResultException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author Chery
// * @date 2017/3/24 - 下午11:52
// */
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRespository userRespository;
//
//    public User login(User user) {
//        User existUser = userRespository.findByUsername(user.getUsername());
//        if (!existUser.getPassword().equals(user.getPassword())) {
//            throw new ResultException(ResultCode.PASSWORD_ERROR);
//        }
//        return existUser;
//    }
//
//    public User save(User user) {
//        return userRespository.save(user);
//    }
//
//}
