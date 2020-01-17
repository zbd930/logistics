package com.yiwutong.service;

import com.yiwutong.Utils.PageBean;
import com.yiwutong.Utils.Swtich;
import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import com.yiwutong.entities.huodai.details;
import com.yiwutong.mapper.ShipMapper;
import com.yiwutong.mapper.amountMapper;
import com.yiwutong.mapper.chehangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class Chaxunservice {

    @Autowired
    private ShipMapper shipMapper;
    @Autowired
    private chehangMapper chehangMapper;
    @Autowired
    private PageBean pageBean;
    @Autowired
    private Swtich swtich;
    @Autowired
    private Ship ship;
    @Autowired
    private Swtich swtich1;
    @Autowired
    private amountMapper amountMapper;

    //查询
    public  List<Ship> get_order_amount(String start, String end, String number,int user_id, HttpSession session){
       List<Ship> list=new ArrayList<>();
        if (!start.equals("")&&!end.equals("")&&number.equals("")&&user_id==0){
             list=shipMapper.get_order(start,end,null,0);
            session.setAttribute("list",list);
        }else if (start.equals("")&&end.equals("")&&!number.equals("")&&user_id==0){
            list=shipMapper.get_order(null,null,number,0);
            session.setAttribute("list",list);
        }
        else if (start.equals("")&&end.equals("")&&number.equals("")&&user_id!=0){
            list=shipMapper.get_order(null,null,null,user_id);
            session.setAttribute("list",list);
        }
        for (Ship s:list
        ) {
            swtich.swtich_schdule(s);
        }
        return list;
    }


    //任务跟踪，获取最新状态
    public Ship get_status( String id) {
        try {
            ship = shipMapper.get_status( id);
            swtich1.swtich_schdule(ship);
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            return ship;
        }
    }
    //任务跟踪，更改最新状态
    public boolean update_status(int status,String number){
        //执行
        if (shipMapper.update_status(status,number)==1) {
            if (status==6){
                shipMapper.update_xiaoorders_status(number);
            }
            if (status==1){
                shipMapper.update_xiaoorders_status_1(number);
            }
            return true;
        }else return false;
    }


    //   货代所有订单的details
    public details getdadetails(int id){
        return shipMapper.get_dadetails(id);
    }

    //    货代所有订单的orders
    public List<order> get_schdule_orders(int item_id,String numbers){
        List<order> list = shipMapper.get_schdule_orders(item_id,numbers);
        for (order order:list
        ) {
            swtich.swtich_order(order);
        }
        return list;
    }
    //    货代所有订单的orders
    public List<order> get_order(int item_id,String numbers){
        List<order> list = shipMapper.get_schdule_orders(item_id,numbers);
        System.out.println(list.size());
        for (order order:list
        ) {
            swtich.swtich_order(order);
        }
        return list;
    }
    //删除用户订单
    public Boolean delete_order(String number,Float weight,Float volume,int order_id){
        if(chehangMapper.delete_order(number)==1){
            //更新仓位
            shipMapper.update_order_details(weight,volume,order_id);
            //删除价格
            amountMapper.updata_price_after_delete(order_id);
            return true;
        }else return false;
    }
    //根据method查询
    public List<Ship> get_items_method(String method){
        List<Ship> ships= shipMapper.get_items_method(method);
        for (Ship Ship:ships
        ) {
            swtich.swtich_schdule(Ship);
        }
        return ships;
    }

    //删除
    public int delete(int id){
        return shipMapper.delete_by_id(id);
    }

    //置顶操作
    public int top(String number){
        int result=0;
        int top=shipMapper.before_update(number);
        if (top==0){
            shipMapper.update(1,number);
            result=1;
        }else {
            shipMapper.update(0,number);
            result=2;
        }return result;
    }


}
