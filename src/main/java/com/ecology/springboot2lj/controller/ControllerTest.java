package com.ecology.springboot2lj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @RequestMapping("/hello")
    public String test1(){
        return "helloGit";
    }

    @RequestMapping("/hello1")
    public String test11(){
        return "helloGit";
    }

    @RequestMapping("/hello2")
    public String test12(){
        return "helloGit";
    }

    @RequestMapping("/hello3")
    public String test13(){
        return "helloGit";
    }
}
