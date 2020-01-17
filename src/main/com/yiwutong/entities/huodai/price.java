package com.yiwutong.entities.huodai;

import java.sql.Date;

public class price {

    private int id;
    private float west;
    private float middle;
    private float east;
    private int user_id;
    private Date valid_date_start;
    private Date valid_start_end;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWest() {
        return west;
    }

    public void setWest(float west) {
        this.west = west;
    }

    public float getMiddle() {
        return middle;
    }

    public void setMiddle(float middle) {
        this.middle = middle;
    }

    public float getEast() {
        return east;
    }

    public void setEast(float east) {
        this.east = east;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getValid_date_start() {
        return valid_date_start;
    }

    public void setValid_date_start(Date valid_date_start) {
        this.valid_date_start = valid_date_start;
    }

    public Date getValid_start_end() {
        return valid_start_end;
    }

    public void setValid_start_end(Date valid_start_end) {
        this.valid_start_end = valid_start_end;
    }
}
