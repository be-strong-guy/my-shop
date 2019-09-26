package com.zrj.my.shop.web.admin.service;

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

    void insert(TbUser tbUser);

    TbUser selectOne(Long id);

    void updateTbUser(TbUser tbUser);

    void deleteOne(Long id);

    List<TbUser> selectByUsername(String username);
}
