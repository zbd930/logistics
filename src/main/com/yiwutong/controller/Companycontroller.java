package com.yiwutong.controller;

import com.yiwutong.Utils.PageBean;
import com.yiwutong.entities.User;
import com.yiwutong.entities.company.supplier_company;
import com.yiwutong.service.Companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company/")
public class Companycontroller {
    @Autowired
    private Companyservice companyservice;
    @Autowired
    private PageBean pageBean;

    @RequestMapping("get.do")
    public ModelAndView get_all(ModelAndView mv,int page){
        mv.setViewName("manage/hudoai");
        try {
            pageBean=companyservice.get_all(10,page);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.addObject("pagebean",pageBean);
        return mv;
    }

    //获取所有发货人
    @RequestMapping("get_address.do")
    public ModelAndView get_all_sucscriber(ModelAndView mv,int page){
        mv.setViewName("manage/fahuoren");
        try {
            pageBean=companyservice.get_all_address(10,page);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.addObject("pagebean",pageBean);
        return mv;
    }
    //修改赔偿条款
    @RequestMapping("peichang.do")
    public String peichang(ModelAndView mv,int id,String peichang){
        try {
            companyservice.peichang(peichang, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/company/get.do?page=1";
    }
    //新增
    @RequestMapping("add.do")
    public ModelAndView add(ModelAndView mv, supplier_company supplier_company, User user){
        int result=0;
        mv.setViewName("redirect:/company/get.do?page=1");
        try{
            result=companyservice.add(user,supplier_company);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result==1){
            mv.addObject("jieguo","成功");
        }else {
            mv.addObject("jieguo","失败");
        }
        return mv;
    }
    //新增
    @RequestMapping("add_address.do")
    public ModelAndView add_address(supplier_company supplier_company,ModelAndView mv){
        int result=0;
        mv.setViewName("redirect:/company/get.do?page=1");
        try{
            result=companyservice.add(null,supplier_company);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result==1){
            mv.addObject("jieguo","成功");
        }else {
            mv.addObject("jieguo","失败");
        }
        return mv;
    }
}
