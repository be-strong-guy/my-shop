package com.zrj.my.shop.web.admin.service;

import com.zrj.my.shop.domain.TbContent;
import com.zrj.my.shop.domain.TbUser;

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
    void insert(TbContent tbContent);

    /**
     * 查询一个内容
     * @param id
     * @return
     */
    TbUser selectOne(Long id);

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
     * @param map  ,两个参数，一个是start起始查询位置，length查询条数
     * @return
     */
    List<TbContent> page(Map<String,Object> map);

    /**
     * 获得总记录数
     * @return
     */
    int getCount(TbContent tbContent);
}
