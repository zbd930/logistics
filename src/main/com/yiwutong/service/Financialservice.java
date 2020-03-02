package com.yiwutong.service;

import com.yiwutong.Utils.PageBean;
import com.yiwutong.Utils.Swtich;
import com.yiwutong.entities.amount;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.mapper.amountMapper;
import com.yiwutong.mapper.chehangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class Financialservice {
    @Autowired
    private com.yiwutong.mapper.chehangMapper chehangMapper;
    @Autowired
    private PageBean pageBean;
    @Autowired
    private Swtich swtich;

    public PageBean get_zhangdan(String method, String numbers, int pageSize, int page, HttpSession session){
        List<order> list =new ArrayList<>();
        list =chehangMapper.get_zhangdan(method,(page-1)*10, pageSize,numbers);
//        if (method!=null&&number==null) {
//            list =chehangMapper.get_zhangdan(method,null,(page-1)*10, pageSize);
//        }else if(method==null&&number!=null){
//            list = chehangMapper.get_zhangdan(null,number,0,0);
//        }
        for (order s:list
        ) {
            swtich.swtich_order(s);
        }
        session.setAttribute("biaoge",list);
        int allRows = list.size();
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
