package com.zrj.my.shop.service.impl;

import com.zrj.my.shop.commons.context.SpringContext;
import com.zrj.my.shop.dao.UserDao;
import com.zrj.my.shop.entity.User;
import com.zrj.my.shop.service.UserService;

/**
 * @program: UserServiceImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:33
 **/
public class UserServiceImpl implements UserService {
    public User login(String email, String password) {
        SpringContext springContext = new SpringContext();
        UserDao userDao = (UserDao) springContext.getBean("userDao");
        return userDao.getUser(email,password);
    }
}
