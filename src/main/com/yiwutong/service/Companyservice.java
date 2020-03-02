package com.yiwutong.service;

import com.yiwutong.Utils.MD5Utils;
import com.yiwutong.Utils.PageBean;
import com.yiwutong.entities.User;
import com.yiwutong.entities.address;
import com.yiwutong.entities.company.supplier_company;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Companyservice {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private PageBean pageBean;
    @Autowired
    private MD5Utils md5Utils;

    //获取所有供应商
    public PageBean get_all(int pageSize,int page){
        List<supplier_company> list=new ArrayList<>();
        list= (List<supplier_company>) companyMapper.get_all_supplier((page-1)*10,pageSize);
        int allRows=list.size();
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    //获取所有发货人
    public PageBean get_all_address(int pageSize,int page){
        List<address> list=new ArrayList<>();
        list= (List<address>) companyMapper.get_all_subscriber((page-1)*10,pageSize);
        int allRows=list.size();
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    //修改赔偿
    public int peichang(String peichang,int id){
        return companyMapper.update_peichang(peichang,id);
    }

    //新增供应商
    public int add(User user, supplier_company supplier_company){
        if (user!=null) {
            user.setPassword(md5Utils.toMD5(user.getPassword()));
            if (companyMapper.add_user(user) == 1) {
                supplier_company.setUser_id(user.getId());
                companyMapper.add_supplier(supplier_company);
                return 1;
            } else return 0;
        }else {
            companyMapper.add_supplier(supplier_company);
            return 1;
        }
    }
}
