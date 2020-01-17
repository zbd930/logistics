package com.yiwutong.controller;

import com.yiwutong.Utils.ExcelUtil;
import com.yiwutong.Utils.PageBean;
import com.yiwutong.Utils.Swtich;
import com.yiwutong.entities.amount;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.mapper.ShipMapper;
import com.yiwutong.service.Chaxunservice;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chaxun/")
public class Chaxuncontroller {

    @Autowired
    private HttpSession session;
    @Autowired
    private Chaxunservice chaxunservice;
    @Autowired
    private PageBean pageBean;

    //查询
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ModelAndView get_result(ModelAndView mv,String start,String end,String number, int user_id){
        mv.setViewName("chaxun/main");
        List<Ship> list=new ArrayList<>();
        try {
            list=chaxunservice.get_order_amount(start, end, number,user_id,session);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.addObject("list",list);
        return mv;
    }

    //删除
    @RequestMapping("delete.do")
    public ModelAndView delete_items(ModelAndView mv,int id){
        int result=0 ;
        mv.setViewName("chaxun/main");
        try {
            result=chaxunservice.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result==1){
            mv.addObject("jieguo","删除成功了，记得提醒客户");
        }
        else {
            mv.addObject("jieguo","删除失败");

        }
        return mv;
    }


    /**
     *任务跟踪,获取航次订单状态
     * */
    @RequestMapping(value = "chaxun.do",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public ModelAndView get_status(String num,ModelAndView mv) throws Exception{
        Ship ship =chaxunservice.get_status(num);
        if(ship!=null) {
            mv.setViewName("chaxun/track_mission");
            mv.addObject("item", ship);
            return mv;
        }else {
            mv.setViewName("chaxun/track_mission");
            Ship ship1=new Ship();
            ship1.setId(0);
            ship1.setStatu("请重新输入");
            mv.addObject("item", ship1);
            return mv;
        }
    }

    /**
     *任务跟踪,更新航次状态
     * */
    @RequestMapping(value = "genzhong.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public ModelAndView genzhong(ModelAndView mv, int status, String number) throws Exception{
        mv.setViewName("chaxun/track_mission");
        Boolean ture=false;
        try {
            ture=chaxunservice.update_status(status,number);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ture) {
            mv.addObject("my_result","成功");
        } else {
            mv.addObject("my_result","提交错误");
        }
        return mv;
    }

    //根据orders的numbers查询id
    @RequestMapping(value = "check_schdule_id.do",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView check_id(ModelAndView mv,String numbers) {
        List<order> list=new ArrayList();
        try{
            list=chaxunservice.get_schdule_orders(0,numbers);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("/chaxun/user_order");
        mv.addObject("list1",list);
        return mv;
    }
    //删除用户订单
    @RequestMapping("delete_order.do")
    public ModelAndView delete_order(String number,Float weight,Float volume,int order_id,ModelAndView mv){
        mv.setViewName("/chaxun/user_order");
        if(chaxunservice.delete_order(number,weight,volume,order_id)){
            mv.addObject("delete","删除成功");
        }else {
            mv.addObject("delete","删除失败");
        }
        return mv;
    }


    //海派商品
    @RequestMapping(value = "get_items_method.do",produces = "application/json; charset=utf-8")
    public ModelAndView get_items_method(String method,ModelAndView mv){
        mv.setViewName("chaxun/active_items");
        switch (method){
            case ("0"):
                method="海派";
                break;
            case ("1"):
                method="海卡";
                break;
            case ("2"):
                method="空派";
                break;
             case ("3"):
                method="空派(直飞)";
                break;
            case ("4"):
                method="空派(带电)";
                break;
        }
        List<Ship> ships=new ArrayList<>();
        try {
            ships=chaxunservice.get_items_method(method);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.addObject("list",ships);
        return mv;
    }
    //置顶
    @RequestMapping("top.do")
    public String top(String number,ModelAndView mv){
        int result=chaxunservice.top(number);
        return "chaxun/active_items";
    }



    //下载表格
    @RequestMapping(value = "export.do")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Ship> list= (List<Ship>) session.getAttribute("list");
//        Map<String, Object> data = requirementService.query(null);
//        List<Requirement> list = (List<Requirement>) data.get("requirements");
        //excel标题
        String[] title = {"航次订单编号","起运地","拆柜地","方式","计划出发","描述","状态","供应商ID"};
        //excel文件名
        String fileName = "航次信息表.xls";
        //sheet名
        String sheetName = "航次信息表";

        String[][] content = new String[list.size()+1][title.length];
        for (int i = 0; i < list.size(); i++) {
            Ship r = list.get(i);
            System.out.println(r.toString());
            content[i][0] = r.getNumber()+"";
            content[i][1] = r.getQiyungang();
            content[i][2] = r.getMudigang();
            content[i][3] = r.getMethod();
            content[i][4] = String.valueOf(r.getEtd());
            content[i][5] = r.getDesc();
            content[i][6] = r.getStatu();
            content[i][7] = String.valueOf(r.getDetails().getCompensate());
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
