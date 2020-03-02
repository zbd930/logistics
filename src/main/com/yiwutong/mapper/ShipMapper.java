package com.yiwutong.mapper;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.chehang.order_details;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.entities.huodai.details;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ShipMapper {

    //更新确认后的数据
    order get_itemid_userid_id(String number);

    //    获取货代全部订单
    List<Ship> get_order(@Param("start") String start,@Param("end")String end,@Param("number")String number,@Param("user_id")int user_id);


    //     <!--获取schdule对应的所有order-->
    List<order> get_schdule_orders(@Param("item_id")int item_id,@Param("numbers")String numbers);

    //    获取大订单的details
    details get_dadetails(int ship_id);
    //从redis取出数据更新到数据库
    int update_data_byid(order_details order_details);
    //删除
    int delete_by_id(int id);

    //根据method查询
    List<Ship> get_items_method(String method);
    //置顶
    int update(@Param("top") int top,@Param("number")String number);
    //置顶前确认
    int before_update(@Param("number")String number);

    //    获得最新状态
    Ship get_status( @Param("number") String number);

    //    更新最新状态
    int update_status(@Param("status") int status, @Param("number") String number);
    //    <!--当大订单结束时确认小订单已经完成-->
    int update_xiaoorders_status(String number);
    //更改小订单为3
    int update_xiaoorders_status_1(String number);

    //判断方法
    Ship get_method(int item_id);


    //删除用户订单更新数据
    int update_order_details(@Param("weight") Float weight, @Param("volume") Float volume, @Param("order_id") int order_id);

}
