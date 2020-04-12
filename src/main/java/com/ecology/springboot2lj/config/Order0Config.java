package com.ecology.springboot2lj.config;

import com.ecology.springboot2lj.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 用于测试order注解的顺序，值越小，优先级越大
 */
@Configuration
@Order(0)
public class Order0Config {
    @Bean
    public StudentServiceImpl Order0Config(){
        System.out.println("Order0Config 加载了");
        return new StudentServiceImpl();
    }
}
