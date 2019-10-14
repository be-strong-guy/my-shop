package com.zrj.my.shop.web.admin.dao;

import com.zrj.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    /**
     * 类目的列表页
     * @return
     */
    List<TbContentCategory> getContentList();
}
