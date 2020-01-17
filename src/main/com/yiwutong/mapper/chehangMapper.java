package com.yiwutong.mapper;

import com.yiwutong.entities.amount;
import com.yiwutong.entities.chehang.order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface chehangMapper {

    List<order> get_zhangdan(@Param("method")String method, @Param("currIndex") int currIndex, @Param("pageSize") int pageSize, @Param("numbers")String numbers);

    //更新确认后的数据


    //更新确认过后的数据
    int updata_data_confirmed(@Param("ctn") int ctn, @Param("volume") float volume, @Param("weight") float weight, @Param("number") String number);


    // 任务查看
    List<order> get_orders(@Param("user_id") int user_id, @Param("currIndex") int currIndex, @Param("pageSize") int pageSize);
    // 任务查看
    List<order> get_order_all(@Param("user_id") int user_id);

    //    未完成
    List<order> get_orders_uncompleted(int user_id);

    //    全部任务
    List<order> get_all_mission(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize, @Param("user_id") int user_id);
    //    全部任务
    List<order> get_all_mission2(@Param("user_id") int user_id);

    //    接单前确认结果
    int before_update(int id);
    //    接单前查看是否有10票以内的任务
    List<order> get_userid(int user_id);
    //    接单
    int update_order(@Param("id") int id, @Param("driver_id") int driver_id, @Param("car_id") int car_id);

    //    车行全部页面ID查找
    List<order> get_by_id(@Param("user_id") int user_id, @Param("numbers") String numbers);

    //  AOP中，发邮件前获取order的item_id对应的address_Id
    List<order> get_address_id(String number);

//    更新数据
    int update_change(int order_id);
//    判断是否更新过数据
    int get_change(int order_id);
    //更新数据后，海卡需要知道目的港
    order get_mudigang_haika(int id);
    //更新数据后,需要知道拆贵港
    order get_chaigui_addition(int id);

    //删除用户订单
    int delete_order(String numbers);

    //删除用户订单更新数据
    int update_order_details(@Param("weight") String weight, @Param("volume") String volume, @Param("order_id") int order_id);
}
