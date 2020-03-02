package com.yiwutong.entities;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.huodai.Ship;

import java.math.BigDecimal;

public class amount {
    private int amount_id;
    private int order_id;
    private BigDecimal paid;
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal customer;
    private BigDecimal inspect;
    private BigDecimal local;
    private BigDecimal additional;
    private int item_id;
    private String openid;
    private order order;
    private Ship ship;

    public BigDecimal getCustomer() {
        return customer;
    }

    public void setCustomer(BigDecimal customer) {
        this.customer = customer;
    }

    public BigDecimal getInspect() {
        return inspect;
    }

    public void setInspect(BigDecimal inspect) {
        this.inspect = inspect;
    }

    public BigDecimal getLocal() {
        return local;
    }

    public void setLocal(BigDecimal local) {
        this.local = local;
    }

    public BigDecimal getAdditional() {
        return additional;
    }

    public void setAdditional(BigDecimal additional) {
        this.additional = additional;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public order getOrder() {
        return order;
    }

    public void setOrder(order order) {
        this.order = order;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getAmount_id() {
        return amount_id;
    }

    public void setAmount_id(int amount_id) {
        this.amount_id = amount_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
