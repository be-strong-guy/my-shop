package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.domain.TbContentCategory;
import com.zrj.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/content/category")
public class TbContentCategoryController {
    @Autowired
    private  TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String contentList(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.getContentList();
        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategoryLists", targetList);
        return "content_category_list";
    }

    /**
     * 讲获取到的类目集合重新排序，相应的子类目放在父类目下面
     * @param sourceList 源集合
     * @param targetList 排序后的集合
     * @param parentId  父类目的id
     */
    public void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory : sourceList) {
            //判断集合中元素是否属于传入父类目
            if(tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);
                //判断是否是父类目
                if(tbContentCategory.getIsParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        if(contentCategory.getParentId().equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    };
    
}
