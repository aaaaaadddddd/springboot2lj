package com.ecology.springboot2lj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication()
@MapperScan(value = "com.ecology.springboot2lj.dao")
@EnableScheduling
public class Springboot2ljApplication {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        ConfigurableApplicationContext context = SpringApplication.run(Springboot2ljApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("bean总数:"+ context.getBeanDefinitionCount());

    }

}
