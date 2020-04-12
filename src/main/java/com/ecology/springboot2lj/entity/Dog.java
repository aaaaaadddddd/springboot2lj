package com.ecology.springboot2lj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.UtilityClass;

@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@UtilityClass
//@Accessors(chain = true)
public class Dog {
    private String name;
    private int gender;
    public String getNames(){
        return "names";
    }
}
