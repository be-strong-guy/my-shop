package com.zrj.my.shop.web.admin.service;

import com.zrj.my.shop.domain.User;

/**
 * @program: UserService
 * @description:
 * @author: zrj
 * @create: 2019-09-26 09:16
 **/
public interface UserService {
    public User getUser(String email, String password);
}
