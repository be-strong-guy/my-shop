package com.zrj.my.shop.web.admin.dao;


import com.zrj.my.shop.domain.User;

/**
 * @program: UserDao
 * @description: 获取用户信息
 * @author: zrj
 * @create: 2019-09-11 16:24
 **/
public interface UserDao {
    public User getUser(String email, String password);
}
