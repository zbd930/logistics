package com.yiwutong.entities.chehang;

import org.springframework.stereotype.Component;

@Component
public class temple_data {
    private int ctn;
    private float volume;
    private float weight;
    private String number;
    private float additional;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getAdditional() {
        return additional;
    }

    public void setAdditional(float additional) {
        this.additional = additional;
    }

    public int getCtn() {
        return ctn;
    }

    public void setCtn(int ctn) {
        this.ctn = ctn;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
