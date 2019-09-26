package com.zrj.my.shop.web.admin.web.controller;


import com.zrj.my.shop.domain.User;
import com.zrj.my.shop.web.admin.service.UserService;
import com.zrj.my.shop.commons.constant.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: LoginController
 * @description: 登录
 * @author: zrj
 * @create: 2019-09-11 16:36
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest) {
       User user = userService.getUser(email,password);

       //登录失败
        if(user==null){
            return login();
        }
        //成功
        else {
            //将用户信息存入session会话中
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }


    }

    /**
     * 注销登录
     * @return
     */
    @RequestMapping(value = "loginOut" ,method = RequestMethod.GET)
    public String loginOut(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();//清除session缓存
        return login();
    }
}
