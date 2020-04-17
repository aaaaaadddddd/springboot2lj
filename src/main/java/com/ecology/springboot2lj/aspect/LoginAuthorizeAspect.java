package com.ecology.springboot2lj.aspect;

import com.alibaba.druid.util.StringUtils;
import com.ecology.springboot2lj.constant.CookieConstant;
import com.ecology.springboot2lj.constant.RedisConstant;
import com.ecology.springboot2lj.exception.SellerAuthorizeException;
import com.ecology.springboot2lj.utiles.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LoginAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.ecology.springboot2lj.controller.Seller*.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if(cookie == null){
//            log.warn("【登陆校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        //从Redis中查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
//        if(StringUtils.isEmpty(tokenValue)){
//            log.warn("【登陆校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
    }
}
