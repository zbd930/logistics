package com.yiwutong.entities.chehang;

import com.yiwutong.entities.amount;
import com.yiwutong.entities.company.subscriber_address;
import com.yiwutong.entities.huodai.Ship;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Component
public class order implements Serializable {

    private int id;
    private String numbers;
    private int item_id;
    private int address_id;
    private String statu;
    private int status;
    private Date picking;
    private int user_id;
    private int driver_id;
    private int car_id;
    private String dest;
    private String company_address;
    private subscriber_address subscriber_address;
    private String songhuo;
    private Ship ship;
    private car car;
    private driver driver;
    private amount amount;
    private order_details order_details;

    public String getSonghuo() {
        return songhuo;
    }

    public void setSonghuo(String songhuo) {
        this.songhuo = songhuo;
    }

    public order_details getOrder_details() {
        return order_details;
    }

    public void setOrder_details(order_details order_details) {
        this.order_details = order_details;
    }

    public amount getAmount() {
        return amount;
    }

    public void setAmount(amount amount) {
        this.amount = amount;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public subscriber_address getSubscriber_address() {
        return subscriber_address;
    }

    public void setSubscriber_address(subscriber_address subscriber_address) {
        this.subscriber_address = subscriber_address;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getPicking() {
        return picking;
    }

    public void setPicking(Date picking) {
        this.picking = picking;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public com.yiwutong.entities.chehang.car getCar() {
        return car;
    }

    public void setCar(com.yiwutong.entities.chehang.car car) {
        this.car = car;
    }

    public com.yiwutong.entities.chehang.driver getDriver() {
        return driver;
    }

    public void setDriver(com.yiwutong.entities.chehang.driver driver) {
        this.driver = driver;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


}
