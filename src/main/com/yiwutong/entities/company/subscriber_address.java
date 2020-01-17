package com.yiwutong.entities.company;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class subscriber_address {
    private int id ;
    private String openid;
    private String phone;
    private String name;
    private String address;
    private String email;
    private List<order> orders;
    private Ship ship;

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "subscriber_address{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
