package com.yiwutong.entities.huodai;

import java.sql.Date;

public class details {
        private int id;
        private int ship_id;
        private int ctn;
        private float weight;
        private float volume;
        private Date cut_time;
        private Date cut_end;
        private String price;
        private int compensate;
        private Date dead_date;
        private String category;
        private int money;
        private Ship ship;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCompensate() {
        return compensate;
    }

    public void setCompensate(int compensate) {
        this.compensate = compensate;
    }

    public Date getDead_date() {
        return dead_date;
    }

    public void setDead_date(Date dead_date) {
        this.dead_date = dead_date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCtn() {
        return ctn;
    }

    public void setCtn(int ctn) {
        this.ctn = ctn;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShip_id() {
        return ship_id;
    }

    public void setShip_id(int ship_id) {
        this.ship_id = ship_id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public Date getCut_time() {
        return cut_time;
    }

    public void setCut_time(Date cut_time) {
        this.cut_time = cut_time;
    }

    public Date getCut_end() {
        return cut_end;
    }

    public void setCut_end(Date cut_end) {
        this.cut_end = cut_end;
    }
}
