package com.ecology.springboot2lj.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-04-16 11:39:34
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 367611805037274737L;
    
    private Integer id;
    
    private Integer orderid;
    
    private Integer goodid;
    
    private Object ordermoney;
    
    private String receiveraddress;
    
    private String receivername;

    @JSONField(serialize = false) //转换为json时不包括该属性
    private String receiverphone;
    
    private String paystate;

    @JSONField(format = "yyyy:MM:dd HH:mm:ss") //格式化日期
    private Date paydate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Object getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Object ordermoney) {
        this.ordermoney = ordermoney;
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

}