package com.qchery.funda.modules.sys.dao;

import com.qchery.funda.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Chery
 * @date 2017/5/6 - 下午12:33
 */
@Mapper
public interface UserDao {

    User findByUsername(String username);

    List<User> findAll();

    List<User> findByAgeLargeThan(int age);

}
