package com.zrj.my.shop.web.admin.service;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.commons.dto.PageInfo;
import com.zrj.my.shop.domain.TbContent;

import java.util.List;
import java.util.Map;

public interface TbContentService {

    /**
     * 查询所有
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增一个
     * @param tbContent
     */
    BaseResult save(TbContent tbContent);

    /**
     * 查询一个内容
     * @param id
     * @return
     */
    TbContent selectOne(Long id);

    /**
     * 更新用户
     * @param tbContent
     */
    void updateTbContent(TbContent tbContent);

    /**
     * 删除一个内容
     * @param id
     */
    void deleteOne(Long id);


    /**
     * 批量删除
     * @param id
     */
    void deleteMulti(String[] id);

    /**
     * 分页
     * @param
     * @return
     */
    PageInfo<TbContent> page(int start, int length,int draw,TbContent tbContent);

    /**
     * 获得总记录数
     * @return
     */
    int getCount(TbContent tbContent);
}
