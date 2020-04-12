package com.ecology.springboot2lj.entity;

import java.io.Serializable;

/**
 * (Login)实体类
 *
 * @author makejava
 * @since 2020-04-12 20:35:53
 */
public class Login implements Serializable {
    private static final long serialVersionUID = 659062749696295055L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String openid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

}