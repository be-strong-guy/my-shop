package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: UserController
 * @description: 用户管理controller
 * @author: zrj
 * @create: 2019-09-27 14:14
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    /**
    *
    * @description: 跳转到用户列表
    *
    * @author: zrj
    *
    * @create: 2019/9/27  14:49
    **/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String userList(Model model){
        List<TbUser> tbUserList = tbUserService.selectAll();
        model.addAttribute("TbUsers",tbUserList);
        return "user_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

}
