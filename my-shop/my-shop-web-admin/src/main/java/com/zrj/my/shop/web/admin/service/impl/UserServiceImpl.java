package com.zrj.my.shop.web.admin.service.impl;

import com.zrj.my.shop.domain.User;
import com.zrj.my.shop.web.admin.dao.UserDao;
import com.zrj.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: UserServiceImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-26 09:17
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String email, String password) {
        return userDao.getUser(email,password);
    }
}
