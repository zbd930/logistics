package com.yiwutong.service;

import com.yiwutong.Utils.RedisUtil;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.chehang.order_details;
import com.yiwutong.entities.chehang.temple_data;
import com.yiwutong.entities.company.supplier_company;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.entities.huodai.addition;
import com.yiwutong.entities.huodai.price_haika;
import com.yiwutong.entities.huodai.price_include;
import com.yiwutong.mapper.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

@Service
public class Problemservice {

        @Autowired
        private RedisUtil redisUtil;
        @Autowired
        private chehangMapper chehangMapper;
        @Autowired
        private ShipMapper shipMapper;
        @Autowired
        private priceMapper priceMapper;
        @Autowired
        private amountMapper amountMapper;
        @Autowired
        private additionMapper additionMapper;
        @Autowired
        private CompanyMapper companyMapper;


    //获取数据
        public temple_data get_data(String number){
            Map<String,Object> map=redisUtil.hmget(number);
            temple_data temple_data=new temple_data();
            try {
                    BeanUtils.populate(temple_data,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            return temple_data;
        }

        //确认数据
    public int comfirmed_data(int ctn,float weight,float volume,String number){
            //更新数据
            if(chehangMapper.updata_data_confirmed(ctn,weight,volume,number)==1){
                order order=shipMapper.get_itemid_userid_id(number);
                int item_id=order.getItem_id();
                int user_id=order.getShip().getUser_id();
                int id=order.getId();
                //更新价格，并删除redis
                temple_data data = new temple_data();
                data.setCtn(ctn);
                data.setVolume(volume);
                data.setWeight(weight);
                order_details order_details = new order_details();
                order_details.setCtn(ctn);
                order_details.setWeight(String.valueOf(weight));
                order_details.setVolume(String.valueOf(volume));
                order_details.setOrder_id(id);
                // 根据柜号获取ship对象
                Ship ship = shipMapper.get_method(item_id);
                //获取目的港,包税渠道
                List<price_include> price_include = new ArrayList<>();
                order orders = chehangMapper.get_chaigui_addition(id);
                //获取附加费
                addition addition = get_addition(orders.getOrder_details().getCategory(), user_id);
                if (addition == null) {
                    addition.setPrice(0);
                }
                List<price_haika> price_haikas = new ArrayList<>();
                if (ship.getMethod().equals("美森")) {
                    price_include = priceMapper.get_price_include(user_id, "2", orders.getOrder_details().getChaigui(), String.valueOf(ship.getEtd()),null);
                    set_0(price_include);
                    //更新价格
                    if (update_price(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_include.get(0), id, addition)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                } else if (ship.getMethod().equals("海派")) {
                    price_include = priceMapper.get_price_include(user_id, "1", orders.getOrder_details().getChaigui(), String.valueOf(ship.getEtd()),null);
                    set_0(price_include);
                    //更新价格
                    if (update_price(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_include.get(0), id, addition)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                } else if (ship.getMethod().equals("空派")) {
                    price_include = priceMapper.get_price_include(user_id, "0", orders.getOrder_details().getChaigui(), String.valueOf(ship.getEtd()),null);
                    set_0(price_include);
                    //更新价格
                    if (update_price(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_include.get(0), id, addition)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                } else if (ship.getMethod().equals("空派(直飞)")) {
                    price_include = priceMapper.get_price_include(user_id, "3", orders.getOrder_details().getChaigui(), String.valueOf(ship.getEtd()),null);
                    set_0(price_include);
                    //更新价格
                    if (update_price(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_include.get(0), id, addition)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                } else if (ship.getMethod().equals("空派(带电)")) {
                    price_include = priceMapper.get_price_include(user_id, "4", orders.getOrder_details().getChaigui(), String.valueOf(ship.getEtd()),null);
                    //更新价格
                    if (update_price(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_include.get(0), id, addition)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                } else if (ship.getMethod().equals("海卡")) {
                    order o = chehangMapper.get_mudigang_haika(id);
                    price_haikas = priceMapper.get_price_haika(user_id, o.getDest(), ship.getQiyungang(), String.valueOf(ship.getEtd()),null);
                    if (price_haikas.size() == 0) {
                        price_haikas.get(0).setPrice(0);
                    }
                    //更新价格
                    if (update_price_haika(ship.getMethod(), data.getCtn(), data.getWeight(), data.getVolume(), price_haikas.get(0), id)) {
                        //更新仓位
                        shipMapper.update_data_byid(order_details);
                    }
                }
//                更新数据库,并删除缓存
                redisUtil.del(number);
                return 1;
            }else return 0;


    }

    //更新价格的方法
    private Boolean update_price(String method, int ctn, float weight, float volume, price_include price_include, int id,addition addition){
        BigDecimal price= BigDecimal.valueOf(0);
        int xiangshu=ctn*10;
        float tijizhong= volume*167;
        float danjia =0;
        if (method.equals("海派")){
            if(get_danjai(xiangshu,weight, id, price_include, xiangshu, danjia,addition)){
                return true;
            }else return false;
        }else if(method.equals("美森")){
            if(get_danjai(xiangshu,weight, id, price_include, xiangshu, danjia,addition)){
                return true;
            }else return false;
        } else if(method.equals("空派")) {
            if(get_danjai(xiangshu,weight, id, price_include, tijizhong, danjia,addition)){
                return true;
            }else return false;
        }else if(method.equals("空派(直飞)")) {
            if(get_danjai(xiangshu,weight, id, price_include, tijizhong, danjia,addition)){
                return true;
            }else return false;
        }else if(method.equals("空派(带电)")) {
            if(get_danjai(xiangshu,weight, id, price_include, tijizhong, danjia,addition)){
                return true;
            }else return false;
        }else return false;
    }
    //更新价格的方法,渠道增加要更改海卡
    private Boolean update_price_haika(String method, int ctn, float weight, float volume, price_haika price_haika, int id) {
        if (method.equals("海卡")) {
            if (volume<=2){
                volume=2;
            }
            if (amountMapper.update_price(BigDecimal.valueOf(volume * price_haika.getPrice()), id) == 1) {
                return true;
            } else return false;
        }else return false;
    }
    //获取单价，并更新价格
    private Boolean  get_danjai(int xiangshu,float weight, int id, price_include price_include, float paozhong, float danjia,addition addition) {
        float maozhong=0;
        if(xiangshu>weight){
            maozhong=xiangshu;
        }else{
            maozhong=weight;
        }
        if (paozhong>=maozhong){
            if (paozhong<=100) {
                danjia=price_include.getOne()+addition.getPrice();
            } else if (paozhong-100>0&&paozhong-300<= 0) {
                danjia=price_include.getThree()+addition.getPrice();
            } else if (paozhong-300>0&&paozhong-500<= 0) {
                danjia=price_include.getFive()+addition.getPrice();
            } else if (500-paozhong<0) {
                danjia=price_include.getTen()+addition.getPrice();
            }
            if(amountMapper.update_price(BigDecimal.valueOf(paozhong*danjia),id)==1){
                return true;
            }else return false;
        }else {
            if (maozhong<=100) {
                danjia=price_include.getOne()+addition.getPrice();
            } else if (maozhong-100>0&&maozhong-300<= 0) {
                danjia=price_include.getThree()+addition.getPrice();
            } else if (maozhong-300>0&&maozhong-500<= 0) {
                danjia=price_include.getFive()+addition.getPrice();
            } else if (500-maozhong<0) {
                danjia=price_include.getTen()+addition.getPrice();

            }
            if(amountMapper.update_price(BigDecimal.valueOf(maozhong*danjia),id)==1){
                return true;
            }else return false;

        }
    }
    private void set_0(List<price_include> price_include) {
        if (price_include.size()==0){
            price_include.get(0).setOne(0);
            price_include.get(0).setFive(0);
            price_include.get(0).setThree(0);
            price_include.get(0).setTen(0);
        }
    }
    public addition get_addition(String category,int user_id){
        addition addition= additionMapper.get_price_category(category,user_id);
        if (addition==null){
            addition addition1=new addition();
            addition1.setPrice(0);
            return addition1;
        }else return addition;
    }

    //获取所有账号
    public List<supplier_company> get_company(){
            return companyMapper.get_company();
    }
}
