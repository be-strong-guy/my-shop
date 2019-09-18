package com.zrj.my.shop.service.impl;

import com.zrj.my.shop.commons.context.SpringContext;
import com.zrj.my.shop.dao.UserDao;
import com.zrj.my.shop.entity.User;
import com.zrj.my.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: UserServiceImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:33
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao = SpringContext.getBean("userDao");
    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
