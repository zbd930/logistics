package com.yiwutong.entities.huodai;

import com.yiwutong.entities.chehang.order;
import com.yiwutong.entities.company.supplier_company;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Component
public class Ship implements Serializable {

    private int id;
    private String qiyungang;
    private String mudigang;
    private String method;
    private Date etd;
    private Date eta;
    private int shichang;
    private String desc;
    private int status;
    private String statu;
    private int user_id;
    private String number;
    private details details;
    private String manbipei;
    private List<order> orders;
    private List<supplier_company> companies;

    public String getManbipei() {
        return manbipei;
    }

    public void setManbipei(String manbipei) {
        this.manbipei = manbipei;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public List<supplier_company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<supplier_company> companies) {
        this.companies = companies;
    }

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    public int getShichang() {
        return shichang;
    }

    public void setShichang(int shichang) {
        this.shichang = shichang;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public details getDetails() {
        return details;
    }

    public void setDetails(details details) {
        this.details = details;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQiyungang() {
        return qiyungang;
    }

    public void setQiyungang(String qiyungang) {
        this.qiyungang = qiyungang;
    }

    public String getMudigang() {
        return mudigang;
    }

    public void setMudigang(String mudigang) {
        this.mudigang = mudigang;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "items{" +
                "id=" + id +
                ", qiyungang='" + qiyungang + '\'' +
                ", mudigang='" + mudigang + '\'' +
                ", method='" + method + '\'' +
                ", etd=" + etd +
                ", eta=" + eta +
                '}';
    }
}
