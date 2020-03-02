package com.yiwutong.controller;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.chehang.temple_data;
import com.yiwutong.entities.company.supplier_company;
import com.yiwutong.service.Problemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/problem/")
public class Problemcontroller {

    @Autowired
    private Problemservice problemservice;
    @Autowired
    private com.yiwutong.entities.chehang.temple_data temple_data;

    @RequestMapping("get_redis_data")
    public ModelAndView get_redis_data(ModelAndView mv,String number) {
        try {
            temple_data = problemservice.get_data(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(temple_data.getCtn());
        mv.setViewName("problem/problem");
        mv.addObject("data", temple_data);
        return mv;
    }

    //确认更新数据
    @RequestMapping("confirmed_data.do")
    public ModelAndView confirmed_data(ModelAndView mv,int ctn,float volume,float weight,String number){
        int i=0;
        try {
            i=problemservice.comfirmed_data(ctn,weight,volume,number);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (i==1){
            mv.addObject("final_result","成功");
        }else {
            mv.addObject("final_result","失败");
        }
        mv.setViewName("problem/problem");
        return mv;
    }

    //获取所有供应商
    @RequestMapping("get.do")
    public ModelAndView get(ModelAndView mv){
        mv.setViewName("problem/reset");
        List list=new ArrayList();
        try {
            list = problemservice.get_company();
        }catch (Exception e){
            e.printStackTrace();
        }
            mv.addObject("companies",list);
        return mv;
    }

}
