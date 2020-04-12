package com.ecology.springboot2lj.config;

import com.ecology.springboot2lj.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(2)
public class Order2Config {
    @Bean
    public StudentServiceImpl order2Service(){
        System.out.println("Order2Config 加载了");
        return new StudentServiceImpl();
    }
}
