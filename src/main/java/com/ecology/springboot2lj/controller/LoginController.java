package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.constant.CookieConstant;
import com.ecology.springboot2lj.constant.RedisConstant;
import com.ecology.springboot2lj.entity.Login;
import com.ecology.springboot2lj.entity.Sellerinfo;
import com.ecology.springboot2lj.service.LoginService;
import com.ecology.springboot2lj.service.SellerinfoService;
import com.ecology.springboot2lj.utiles.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping({"/","/index","/login"})
    public String index(){
        return "login";
    }

    /**
     * 登录功能，用户设置进redis，有时效性
     * @param username
     * @param password
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        Map<String, Object> map) {
        String tokenRedis = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, username+password));
        if (tokenRedis!=null){
            if(tokenRedis.equals(username+password)){
                return "index";
            }
        }
        //1. openid去和数据库里的数据匹配
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        List<Login> logins = loginService.queryAll(login);
        //匹配不到openid
        if (logins.size()<1) {
            map.put("msg","openid尚未进行注册" );
            return "bootstrap/404";
        }

        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, username+password), username+password, expire, TimeUnit.SECONDS);
        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        return "index";
    }

    /**
     * 退出功能暂未完成
     * @param request
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        map.put("msg", "退出成功");
        return "退出成功";
    }
}
