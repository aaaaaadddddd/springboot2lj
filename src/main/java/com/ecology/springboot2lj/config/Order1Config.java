package com.ecology.springboot2lj.config;

import com.ecology.springboot2lj.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class Order1Config {
    @Bean
    public StudentServiceImpl Order1Config(){
        System.out.println("Order1Config 加载了");
        return new StudentServiceImpl();
    }
}
