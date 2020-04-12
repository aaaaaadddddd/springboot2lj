package com.ecology.springboot2lj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/imgs/");
        //增加了外部静态资源地址
        registry.addResourceHandler("/custom/**").addResourceLocations("file:E://photos//ipad//DCIM//100APPLE/");

        //增加对Swagger2静态资源的放行
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        //对bootstrap资源文件的放行
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/");


    }
}
