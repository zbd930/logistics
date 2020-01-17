package com.yiwutong.Utils;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import org.springframework.stereotype.Component;

@Component
public class Swtich {

    public Ship swtich_schdule(Ship ship) {
        switch (ship.getStatus()) {
            case 0:
                ship.setStatu("未拼柜");
                return ship;
            case 1:
                ship.setStatu("已装柜");
                return ship;
            case 2:
                ship.setStatu("报关中");
                return ship;
            case 3:
                ship.setStatu("开船");
                return ship;
            case 4:
                ship.setStatu("货到港");
                return ship;
            case 5:
                ship.setStatu("查验中");
                return ship;
            case 6:
                ship.setStatu("已完成");
                return ship;
        }
        return null;
    }
    public String switch_mudigang(String origin){
        switch (origin){
            case "west":
                return "美西";
            case "east":
                return "美东";
            case "middle":
                return "美中";
        }
        return null;
    }
    public order swtich_order(order order){
        switch (order.getStatus()){
            case 0:
                order.setStatu("已下单");
                return order;
            case 1:
                order.setStatu("车行已接单");
                return order;
            case 2:
                order.setStatu("已送达货代公司仓库");
                return order;
            case 3:
                order.setStatu("运输中");
                return order;
            case 4:
                order.setStatu("等待客户自送仓库");
                return order;
            case 5:
                order.setStatu("待评价");
                return order;
            case 6:
                order.setStatu("已到达目的地");
                return order;
        }
        return null;
    }
    public String switch_way(int origin){
        switch (origin){
            case 0:
                return "空派";
            case 1:
                return "海派";
            case 2:
                return "美森";
            case 3:
                return "空派(直飞)";
            case 4:
                return "空派(敏感)";
        }
        return null;
    }
}
