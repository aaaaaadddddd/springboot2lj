package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.annotation.InsertLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试案例
 */
@RestController
public class ControllerTest {
    @InsertLog(logStr = "用户访问了/hello1")
    @RequestMapping("/hello1")
    public String test1(){
        return "helloGit";
    }

    @RequestMapping("/hello2")
    public String test2(){
        return "helloGit";
    }

    @RequestMapping("/hello3")
    public String test3(){
        return "helloGit";
    }

    @RequestMapping("/hello4")
    public String test4(){
        return "helloGit";
    }
}
