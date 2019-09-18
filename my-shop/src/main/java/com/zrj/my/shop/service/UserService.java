package com.zrj.my.shop.service;

import com.zrj.my.shop.entity.User;

/**
 * @program: UserService
 * @description: 登录的业务
 * @author: zrj
 * @create: 2019-09-11 16:32
 **/
public interface UserService {
    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User login(String email,String password);
}
