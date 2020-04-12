package com.ecology.springboot2lj.entity;

import java.io.Serializable;

/**
 * (Sellerinfo)实体类
 *
 * @author makejava
 * @since 2020-04-12 11:03:37
 */
public class Sellerinfo implements Serializable {
    private static final long serialVersionUID = 979983241576783209L;
    
    private Integer id;
    
    private String openid;
    
    private String username;
    
    private String token;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}