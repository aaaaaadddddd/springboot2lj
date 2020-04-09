package com.ecology.springboot2lj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.ecology.springboot2lj.dao")
@SpringBootApplication
public class Springboot2ljApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2ljApplication.class, args);
    }

}
