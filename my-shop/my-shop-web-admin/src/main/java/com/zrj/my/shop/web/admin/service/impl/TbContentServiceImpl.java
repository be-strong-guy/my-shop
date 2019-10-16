package com.zrj.my.shop.web.admin.service.impl;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.commons.dto.PageInfo;
import com.zrj.my.shop.domain.TbContent;
import com.zrj.my.shop.web.admin.dao.TbContentDao;
import com.zrj.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
    public BaseResult save(TbContent tbContent) {

        //验证成功方可保存
        BaseResult baseResult = this.check(tbContent);
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());
            //新增
            if(tbContent.getId()==null){
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            //更新
            else {
                tbContentDao.updateTbContent(tbContent);
            }
            baseResult.setMessage("保存内容信息成功！");
        }
        return baseResult;
    }

    @Override
    public TbContent selectOne(Long id) {
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
    public PageInfo<TbContent> page(int start, int length,int draw,TbContent tbContent) {
        PageInfo<TbContent> pageInfo = new PageInfo<>();
        int count = tbContentDao.getCount(tbContent);
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("tbUser",tbContent);
        pageInfo.setData(tbContentDao.page(map));
        pageInfo.setDraw(draw);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setRecordsTotal(count);

        return pageInfo;
    }

    @Override
    public int getCount(TbContent tbContent) {
        return tbContentDao.getCount(tbContent);
    }

    private BaseResult check(TbContent tbContent){
        BaseResult baseResult = BaseResult.success();
        if(StringUtils.isBlank(tbContent.getContent())){
            baseResult = BaseResult.fail("内容不能为空，请重新输入！");
        }
        return baseResult;
    }
}
