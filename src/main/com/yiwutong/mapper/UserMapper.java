package com.yiwutong.mapper;

import com.yiwutong.entities.User;
import com.yiwutong.entities.company.subscriber_address;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User get_user(@Param("username") String username, @Param("password") String password);

    subscriber_address get_emial(int id);

    //重置密码
    int reset_password(@Param("password") String password, @Param("user_id") int user_id);
}
