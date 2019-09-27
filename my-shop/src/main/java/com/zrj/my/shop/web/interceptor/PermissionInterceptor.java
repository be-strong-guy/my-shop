package com.zrj.my.shop.web.interceptor;

import com.zrj.my.shop.commons.constant.ConstantUtils;
import com.zrj.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: LoginInterceptor
 * @description: 登录的拦截器，拦截未登录的请求
 * @author: zrj
 * @create: 2019-09-19 14:48
 **/
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        // 没有登录的，强制其登录
        if(user == null){
            httpServletResponse.sendRedirect("/login");
        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
