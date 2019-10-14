package com.zrj.my.shop.web.admin.service;

import com.zrj.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    /**
     * 类目的列表页
     * @return
     */
    List<TbContentCategory> getContentList();
}
