package com.ecology.springboot2lj.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-04-08 21:10:10
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -94679176232771403L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}