package com.zrj.my.shop.web.admin.dao.impl;

import com.zrj.my.shop.domain.User;
import com.zrj.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @program: UserDaoImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:27
 **/
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    /**
     * 获得用户信息
     * @param email 用户邮箱
     * @param password 用户密码
     * @return 用户
     */
    public User getUser(String email, String password) {
        logger.debug("调用getUser(),email:{},password:{}",email,password);
        User user = null;
        if("admin@qq.com".equals(email)&&"admin".equals(password)){
            user = new User();
            user.setEmail("admin@qq.com");
            user.setUserName("张三丰");
            logger.info("成功获取\"{}\"的用户信息",user.getUserName());

        }else {
            logger.info("获取用户信息失败！");
        }
        return user;
    }
}
