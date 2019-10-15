package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;
}
