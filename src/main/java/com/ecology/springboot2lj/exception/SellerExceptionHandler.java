package com.ecology.springboot2lj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SellerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value= SellerAuthorizeException.class)
    public String handlerAuthorizeException(){
        return "没有登录，抛出了异常";
    }
}
