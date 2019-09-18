package com.zrj.my.shop.web.controller;

import com.zrj.my.shop.commons.context.SpringContext;
import com.zrj.my.shop.entity.User;
import com.zrj.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: LoginController
 * @description: 登录
 * @author: zrj
 * @create: 2019-09-11 16:36
 **/
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SpringContext springContext = new SpringContext();
        UserService userService = (UserService) springContext.getBean("userService");
        User user = userService.login(email, password);
        //登录成功
        if(user!=null){
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else {
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

}
