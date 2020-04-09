package com.ecology.springboot2lj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-09 12:46:23
 */
@ExcelTarget("20")
public class User implements Serializable {
    private static final long serialVersionUID = 885981936595884029L;

    @Excel(name = "id", width=15)
    @NotBlank(message = "该字段不能为空")
    private Integer id;
    @Excel(name = "姓名", width=15)
    private String name;
    @Excel(name = "年龄", width=15)
    private Integer age;
    @Excel(name = "班级", width=15)
    private String classes;
    @Excel(name = "组", width=15)
    private String groupss;
    @Excel(name = "性别", width=15)
    private Integer gender;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGroupss() {
        return groupss;
    }

    public void setGroupss(String groupss) {
        this.groupss = groupss;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}