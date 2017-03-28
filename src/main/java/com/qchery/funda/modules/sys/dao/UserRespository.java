package com.qchery.funda.modules.sys.dao;

import com.qchery.funda.modules.sys.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qinrui@yonyou.com
 * @version 1.0.0
 * @date 2017/3/28
 */
@Repository
public interface UserRespository extends CrudRepository<User, Integer> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);
}
