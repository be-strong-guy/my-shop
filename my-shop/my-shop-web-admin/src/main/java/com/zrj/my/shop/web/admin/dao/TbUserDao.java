package com.zrj.my.shop.web.admin.dao;

import com.zrj.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: TbUserDao
 * @description:
 * @author: zrj
 * @create: 2019-09-26 15:54
 **/
@Repository
public interface TbUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 新增一个用户
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 查询一个用户
     * @param id
     * @return
     */
    TbUser selectOne(Long id);

    /**
     * 更新用户
     * @param tbUser
     */
    void updateTbUser(TbUser tbUser);

    /**
     * 删除一个用户
     * @param id
     */
    void deleteOne(Long id);

    /**
     * 根据username模糊查询
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 根据邮箱获取单个用户来进行登录验证
     * @param email
     * @return
     */
    TbUser selectByEmail(String email);

    /**
     *
     * 搜索
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
