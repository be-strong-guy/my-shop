package com.zrj.my.shop.web.admin.service;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.commons.dto.PageInfo;
import com.zrj.my.shop.domain.TbUser;

import java.util.List;

/**
 * @program: TbUserService
 * @description:
 * @author: zrj
 * @create: 2019-09-26 15:55
 **/
public interface TbUserService {
    List<TbUser> selectAll();

    /**
     * 保存，可以是更新也可以是新增
     * @param tbUser
     */
    BaseResult save(TbUser tbUser);

    TbUser selectOne(Long id);

    void updateTbUser(TbUser tbUser);

    void deleteOne(Long id);

    List<TbUser> selectByUsername(String username);

    /**
     * 登录验证
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除
     * @param id
     */
    void deleteMulti(String[] id);

    /**
     * 分页
     * @return
     */
    PageInfo<TbUser> page(int start, int length,int draw);

    /**
     * 获得总记录数
     * @return
     */
    int getCount();
}
