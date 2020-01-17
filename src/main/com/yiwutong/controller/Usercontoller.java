package com.yiwutong.controller;

import com.yiwutong.Utils.MD5Utils;
import com.yiwutong.entities.User;
import com.yiwutong.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/User/")
public class Usercontoller {

    @Autowired
    private Userservice userservice;
    @Autowired
    private MD5Utils md5Utils;

    //登陆
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ModelAndView login(String name, String password, ModelAndView modelAndView, HttpSession session){
        User user=new User();
                try {
                    user=userservice.get_user(name, password);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(user!=null) {
            modelAndView.setViewName("main/menu");
            session.setAttribute("user", user);
            return modelAndView;
        }else {
            modelAndView.setViewName("../index");
            modelAndView.addObject("the_result","登录账号密码错误");
            return modelAndView;
        }
    }

    //    退出登陆
    @RequestMapping("Menuservlet_exit.do")
    public void Menuservlet_exit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    //重置密码
    @RequestMapping("reset.do")
    public ModelAndView reset(ModelAndView mv,int user_id){
        mv.setViewName("redirect:/problem/get.do");
        String password="1111";
        if(userservice.reset(user_id,md5Utils.toMD5(password))==1){
            mv.addObject("password","成功");
        }else {
            mv.addObject("password","失败");
        }
        return mv;
    }
}
