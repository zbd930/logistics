package com.yiwutong.entities.chehang;

public class order_details {
    private int id;
    private int ctn;
    private String weight;
    private String volume;
    private String beizhu;
    private int order_id;
    private String ups;
    private String chaigui;
    private String category;
    private order order;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChaigui() {
        return chaigui;
    }

    public void setChaigui(String chaigui) {
        this.chaigui = chaigui;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public com.yiwutong.entities.chehang.order getOrder() {
        return order;
    }

    public void setOrder(com.yiwutong.entities.chehang.order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCtn() {
        return ctn;
    }

    public void setCtn(int ctn) {
        this.ctn = ctn;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }
}
