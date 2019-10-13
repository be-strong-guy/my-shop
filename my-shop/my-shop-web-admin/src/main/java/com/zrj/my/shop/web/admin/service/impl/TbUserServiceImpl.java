package com.zrj.my.shop.web.admin.service.impl;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.commons.dto.PageInfo;
import com.zrj.my.shop.commons.utils.RegexpUtils;
import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.dao.TbUserDao;
import com.zrj.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: TbUserServiceImpl
 * @description:
 * @author: zrj
 * @create: 2019-09-26 15:56
 **/
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        //验证成功方可保存
        BaseResult baseResult = this.check(tbUser);
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            //新增
            if(tbUser.getId()==null){
                //加密密码
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //更新
            else {
                tbUserDao.updateTbUser(tbUser);
            }
            baseResult.setMessage("保存用户信息成功！");
        }
       return baseResult;
    }

    @Override
    public TbUser selectOne(Long id) {
        return tbUserDao.selectOne(id);
    }

    @Override
    public void updateTbUser(TbUser tbUser) {
        tbUserDao.updateTbUser(tbUser);
    }

    @Override
    public void deleteOne(Long id) {
        tbUserDao.deleteOne(id);
    }


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.selectByEmail(email);
        if(tbUser!=null){
            //加密后的密码
            String md5Passwod = DigestUtils.md5DigestAsHex(password.getBytes());
            if(md5Passwod.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }



    @Override
    public void deleteMulti(String[] id) {
        tbUserDao.deleteMulti(id);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser) {
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        int count = tbUserDao.getCount(tbUser);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("tbUser",tbUser);
        pageInfo.setData(tbUserDao.page(map));
        pageInfo.setDraw(draw);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setRecordsTotal(count);

        return pageInfo;
    }

    @Override
    public int getCount(TbUser tbUser) {
        return tbUserDao.getCount(tbUser);
    }

    private BaseResult check(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();
        if(StringUtils.isBlank(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入！");
        }else if (!RegexpUtils.checkEmail(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入！");
        }else  if(StringUtils.isBlank(tbUser.getPassword())){
            baseResult = BaseResult.fail("密码不能为空，请重新输入！");
        }else if(StringUtils.isBlank(tbUser.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空，请重新输入！");
        }else  if(StringUtils.isBlank(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机号不能为空，请重新输入！");
        }else if (!RegexpUtils.checkPhone(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机号格式不正确，请重新输入！");
        }
        return baseResult;
    }
}
