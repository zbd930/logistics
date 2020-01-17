package com.yiwutong.controller;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.details;
import com.yiwutong.service.Chaxunservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jump/")
public class Jumpcontroller {

    @Autowired
    private Chaxunservice chaxunservice;

    @RequestMapping("chaxun.do")
    //查询主页面
    public String chaxun(){
     return "chaxun/main";
    }

    @RequestMapping("pingui.do")
    //查询现有商品
    public String chaxun_active(){
        return "chaxun/active_items";
    }
    @RequestMapping("user_order.do")
    //用户订单
    public String user_order(){
        return "chaxun/user_order";
    }


    @RequestMapping("genzhong.do")
    //货物跟踪
    public String genzhong(){
        return "chaxun/track_mission";
    }

    //异常跟踪
    @RequestMapping("problem.do")
    public String problem(){
        return "problem/problem";
    }

    //金额
    @RequestMapping("jine.do")
    public String jine(){
        return "financial/orders";
    }


    @RequestMapping("details.do")
    //详细
    public ModelAndView details(ModelAndView mv,int id){
        //详细信息
        details details=chaxunservice.getdadetails(id);
        //所有订单
        List<order> list=chaxunservice.get_schdule_orders(id,null);
        mv.addObject("details",details);
        mv.addObject("list",list);
        mv.setViewName("chaxun/details");
        return mv;
    }
}
