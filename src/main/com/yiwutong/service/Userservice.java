package com.yiwutong.service;

import com.yiwutong.entities.User;
import com.yiwutong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {


        @Autowired
        private UserMapper userMapper;

        //登陆
    public User get_user(String name, String password){
        return userMapper.get_user(name,password);
    }

    //重置密码
    public int reset(int user_id,String password){
        int i=0;
        try {
            i=userMapper.reset_password(password,user_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;

    }
}
