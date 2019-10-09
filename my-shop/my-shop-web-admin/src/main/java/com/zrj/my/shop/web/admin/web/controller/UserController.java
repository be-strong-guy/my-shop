package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser = null;
        if(id!=null){
            tbUser = tbUserService.selectOne(id);
        }else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

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

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser,Model model, RedirectAttributes redirectAttributes){

        BaseResult baseResult = tbUserService.save(tbUser);
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }

    }
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model){
        List<TbUser> tbUsers = tbUserService.search(keyword);
        model.addAttribute("TbUsers",tbUsers);
        return "user_list";
    }
}
