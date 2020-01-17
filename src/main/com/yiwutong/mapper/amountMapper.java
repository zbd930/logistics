package com.yiwutong.mapper;

import com.yiwutong.entities.amount;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface amountMapper {
    //月份总金额
    amount get_total_byhuodai(@Param("start_data") String start_data, @Param("end_data") String end_data, @Param("user_id") int user_id);

    //当月所有订单金额
    List<amount> get_order_amount(@Param("start_data") String start_data, @Param("end_data") String end_data, @Param("user_id") int user_id);

    //获取某个订单金额
    List<amount> order_amount(@Param("numbers") String numbers, @Param("user_id") int user_id);
    //更新杂费
   int updata_local(@Param("tax") String tax, @Param("customer") String customer, @Param("inspect") String inspect, @Param("order_id") int order_id);

   //更新附加费
    int update_additional(@Param("additional") float additional, @Param("order_id") int order_id);
    //更新数据时更新价格
    int update_price(@Param("total") BigDecimal total, @Param("order_id") int order_id);
    //删除订单后更新价格
    int updata_price_after_delete(int order_id);
}
