package com.zrj.my.shop.dao.impl;

import com.zrj.my.shop.dao.UserDao;
import com.zrj.my.shop.entity.User;

/**
 * @program: UserDaoImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:27
 **/
public class UserDaoImpl implements UserDao {

    /**
     * 获得用户信息
     * @param email 用户邮箱
     * @param password 用户密码
     * @return 用户
     */
    public User getUser(String email, String password) {
        User user = null;
        if("admin@qq.com".equals(email)&&"admin".equals(password)){
            user = new User();
            user.setEmail("admin@qq.com");
            user.setUsername("张三丰");
        }
        return user;
    }
}
