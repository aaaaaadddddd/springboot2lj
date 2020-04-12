package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.annotation.InsertLog;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试案例
 */
@Controller
public class ControllerTest {
    @ApiOperation(value="测试类接口1", notes="获取测试的字符串1")
    @InsertLog(logStr = "用户访问了/hello1")
    @RequestMapping("/hello1")
    public String test1(){
        return "helloGit";
    }

    @ApiOperation(value="测试类接口2", notes="获取测试的字符串2")
    @ApiImplicitParam(name = "name", value = "请求中的参数name", required = true, dataType = "String")
    @PostMapping("/hello2")
    public String test2(@RequestBody String name, @RequestParam String name1){
        return "name:"+name+",  name1:"+name1;
    }

    @ApiOperation(value="测试类接口3", notes="获取测试的字符串3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "请求体body中的参数name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name1", value = "请求中的参数name", required = true, dataType = "String")
    })

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping("/hello3")
    private String test3(@RequestBody String name, @RequestParam String name1){
        return  "name:"+name+",  name1:"+name1;
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping("/hello4")
    public String test4(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "默认值springboot-thymeleaf") String name){
        request.setAttribute("name",name);
        return "index";
    }
}
