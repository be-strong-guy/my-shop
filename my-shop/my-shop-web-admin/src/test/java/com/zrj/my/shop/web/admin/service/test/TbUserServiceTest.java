package com.zrj.my.shop.web.admin.service.test;

import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: TbUserServiceTest
 * @description: 测试类，测试TbUserService
 * @author: zrj
 * @create: 2019-09-26 16:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;
    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setCreated(new Date());
        tbUser.setEmail("admin2@qq.com");
        tbUser.setPhone("1233551111");
        tbUser.setUpdated(new Date());
        tbUser.setUsername("张无忌");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("12345".getBytes()));
        tbUserService.save(tbUser);
    }

    @Test
    public void testSelectOne(){
        TbUser tbUser = tbUserService.selectOne(37L);
        System.out.println(tbUser.getUsername());
    }
    @Test
    public void testDeleteOne(){
        tbUserService.deleteOne(36L);
    }

    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.selectOne(22L);
        tbUser.setUsername("含光");

        tbUserService.updateTbUser(tbUser);
    }

    @Test
    public void testSelectByUsername(){
        List<TbUser> tbUserList = tbUserService.selectByUsername("张");
        for (TbUser tbUser : tbUserList) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void testMD5(){
        System.out.println(DigestUtils.md5DigestAsHex("12345".getBytes()));
    }
}
