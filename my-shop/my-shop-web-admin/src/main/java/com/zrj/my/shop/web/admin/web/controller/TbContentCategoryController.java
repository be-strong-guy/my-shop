package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/content/category")
public class TbContentCategoryController {
    @Autowired
    private  TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String contentList(){
        return "content_category_list";
    }
}
