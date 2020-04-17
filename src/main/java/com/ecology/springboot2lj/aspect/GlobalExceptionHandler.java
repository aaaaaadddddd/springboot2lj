package com.ecology.springboot2lj.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局捕获异常
 * @author luojie
 *
 */
@ControllerAdvice("com.ecology.springboot2lj.controller")
public class GlobalExceptionHandler {
    //捕获运行期异常
    @ExceptionHandler(Exception.class)
    public String exception(){
        return "404";
    }
}
