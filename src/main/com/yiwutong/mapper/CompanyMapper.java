package com.yiwutong.mapper;

import com.yiwutong.entities.User;
import com.yiwutong.entities.address;
import com.yiwutong.entities.company.supplier_company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {

    //获取所有发货人
    List<address> get_all_subscriber(@Param("page")int page, @Param("pageSize")int pageSize);

    //获取所有供应商
    List<supplier_company> get_all_supplier(@Param("page")int page, @Param("pageSize")int pageSize);

    //修改赔偿
    int update_peichang(@Param("peichang")String peichang, @Param("supplier_id")int supplier_id);

    //新增供应商第二部
    int add_supplier(supplier_company supplier_company);

    //新增供应商第一步
    int add_user(User user);

    //获取所有账号
    List<supplier_company> get_company();
}
