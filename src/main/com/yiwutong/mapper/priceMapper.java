package com.yiwutong.mapper;

import com.yiwutong.entities.huodai.price_haika;
import com.yiwutong.entities.huodai.price_include;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface priceMapper {

    List<price_include> get_price_include(@Param("user_id") int user_id, @Param("way") String way, @Param("area") String area, @Param("start_data") String start_data, @Param("country") String country);
//    List<price_include> get_price_kongpai(@Param("user_id") int user_id, @Param("area") String area, @Param("start_data") String start_data);
//    List<price_include> get_price_meiseng(@Param("user_id") int user_id, @Param("area") String area, @Param("start_data") String start_data);
    List<price_haika> get_price_haika(@Param("user_id") int user_id, @Param("mudigang") String mudigang, @Param("qiyungang") String qiyungang, @Param("start_data") String start_data,@Param("country") String country);
    int  delete_price_haipai(int id);
    int  delete_price_haika(int id);
    int  insert_price_haika(price_haika price_haika);

    int insert_price(price_include price_include);
      //  <!--更改价格前确认该时间段有无同类型的价格不包税-->
    List<price_haika> check_ship_noincludetax(@Param("qiyungang") String qiyungang, @Param("mudigang") String mudigang, @Param("user_id") int user_id);
    //  <!--更改价格前确认该时间段有无同类型的价格包税-->
    List<price_include> check_ship_includetax(@Param("area") String area, @Param("way") String way, @Param("user_id") int user_id);
}
