package com.zrj.my.shop.web.admin.service.impl;

import com.zrj.my.shop.domain.TbContent;
import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.dao.TbContentDao;
import com.zrj.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {

        return tbContentDao.selectAll();
    }

    @Override
    public void insert(TbContent tbContent) {
        tbContentDao.insert(tbContent);
    }

    @Override
    public TbUser selectOne(Long id) {
        return tbContentDao.selectOne(id);
    }

    @Override
    public void updateTbContent(TbContent tbContent) {
        tbContentDao.updateTbContent(tbContent);
    }

    @Override
    public void deleteOne(Long id) {
        tbContentDao.deleteOne(id);
    }

    @Override
    public void deleteMulti(String[] id) {
        tbContentDao.deleteMulti(id);
    }

    @Override
    public List<TbContent> page(Map<String, Object> map) {
        return tbContentDao.page(map);
    }

    @Override
    public int getCount(TbContent tbContent) {
        return tbContentDao.getCount(tbContent);
    }
}
