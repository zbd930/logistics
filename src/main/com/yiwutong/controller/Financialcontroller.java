package com.yiwutong.controller;

import com.yiwutong.Utils.ExcelUtil;
import com.yiwutong.Utils.PageBean;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.service.Financialservice;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/financial/")
public class Financialcontroller {

    @Autowired
    private Financialservice financialservice;
    @Autowired
    private PageBean pageBean;
    @Autowired
    private HttpSession session;

    @RequestMapping("get_zhangdan.do")
    public ModelAndView get_zhangdan(String method,String numbers,ModelAndView mv,int page){
        mv.setViewName("financial/orders");
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
                method="空派（直飞）";
                break;
            case ("4"):
                method="空派（带电)";
                break;
        }
        try {
           pageBean=financialservice.get_zhangdan(method,numbers,10,page,session);
       }catch (Exception e){
           e.printStackTrace();
       }
       mv.addObject("pagebean",pageBean);
        return mv;
    }

    //下载表格
    @RequestMapping(value = "export.do")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<order> list= (List<order>) session.getAttribute("biaoge");
//        Map<String, Object> data = requirementService.query(null);
//        List<Requirement> list = (List<Requirement>) data.get("requirements");
        //excel标题
        String[] title = {"用户订单编号","供应商ID","起运地","目的地","状态","起运时间","件数","重量","体积","品名","已支付运费"
                ,"报关费","关税","查验费","总运费","方式"};
        //excel文件名
        String fileName = "价格信息表.xls";
        //sheet名
        String sheetName = "价格信息表";

        String[][] content = new String[list.size()+1][title.length];
        for (int i = 0; i < list.size(); i++) {
            order r = list.get(i);
            content[i][0] = r.getNumbers()+"";
            content[i][1] = String.valueOf(r.getShip().getUser_id());
            content[i][2] = r.getShip().getQiyungang();
            content[i][3] = r.getDest();
            content[i][4] = r.getStatu();
            content[i][5] = String.valueOf(r.getShip().getEtd());
            content[i][6] = String.valueOf(r.getOrder_details().getCtn());
            content[i][7] = r.getOrder_details().getWeight();
            content[i][8] = r.getOrder_details().getVolume();
            content[i][9] = r.getOrder_details().getCategory();
            content[i][10] = String.valueOf(r.getAmount().getPaid());
            content[i][11] = String.valueOf(r.getAmount().getCustomer());
            content[i][12] = String.valueOf(r.getAmount().getTax());
            content[i][13] = String.valueOf(r.getAmount().getInspect());
            content[i][14] = String.valueOf(r.getAmount().getTotal());
            content[i][15] = r.getShip().getMethod();
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
