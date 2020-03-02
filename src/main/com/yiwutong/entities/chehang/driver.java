package com.yiwutong.entities.chehang;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class driver {
    private int id;
    private String phone;
    private int user_id;
    private String id_card;
    private String name;
    private List<order> orders;

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    @Override
    public String toString() {
        return "driver{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", user_id=" + user_id +
                ", id_card='" + id_card + '\'' +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
