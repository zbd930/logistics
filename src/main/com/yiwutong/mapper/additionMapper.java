package com.yiwutong.mapper;

import com.yiwutong.entities.huodai.addition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface additionMapper {

    //添加附加费
    int add_price(addition addition);
    //获取附加费种类
    addition get_price_category(@Param("category") String category, @Param("user_id") int user_id);
    //获取附加费
    List<addition> get_price(@Param("user_id") int user_id);

    //删除附加费
    int delete_price(@Param("addition_id") int addition_id);
}
