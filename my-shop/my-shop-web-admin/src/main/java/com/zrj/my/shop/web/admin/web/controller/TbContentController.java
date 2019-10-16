package com.zrj.my.shop.web.admin.web.controller;

import com.zrj.my.shop.commons.dto.BaseResult;
import com.zrj.my.shop.commons.dto.PageInfo;
import com.zrj.my.shop.domain.TbContent;
import com.zrj.my.shop.domain.TbUser;
import com.zrj.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if(id!=null){
            tbContent = tbContentService.selectOne(id);
        }else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     *
     * @description: 跳转到内容列表
     *
     * @author: zrj
     *
     * @create: 2019/9/27  14:49
     **/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String contentList(){

        return "user_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){

        BaseResult baseResult = tbContentService.save(tbContent);
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }

    }


    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult =null;
        if(StringUtils.isNotBlank(ids)){
            String[] id = ids.split(",");
            tbContentService.deleteMulti(id);
            baseResult = BaseResult.success("删除成功！");
        }else {
            baseResult = BaseResult.fail("删除失败！");
        }
        return baseResult;
    }

    /**
     * 分页功能
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest httpServletRequest, TbContent tbContent){
        String s_draw = httpServletRequest.getParameter("draw");
        String s_start = httpServletRequest.getParameter("start");
        String s_length = httpServletRequest.getParameter("length");
        int draw = s_draw==null?0:Integer.parseInt(s_draw);
        int start = s_start==null?0:Integer.parseInt(s_start);
        int length = s_length==null?20:Integer.parseInt(s_length);

        PageInfo<TbContent> pageInfo = tbContentService.page(start, length,draw,tbContent);

        return pageInfo;
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "user_detail";
    }
}
