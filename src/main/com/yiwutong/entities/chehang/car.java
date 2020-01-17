package com.yiwutong.entities.chehang;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class car {
    private int id;
    private String car_number;
    private int user_id;
    private List<order> orders;

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", car_number='" + car_number + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
