package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.constant.CookieConstant;
import com.ecology.springboot2lj.constant.RedisConstant;
import com.ecology.springboot2lj.entity.Login;
import com.ecology.springboot2lj.entity.Sellerinfo;
import com.ecology.springboot2lj.service.LoginService;
import com.ecology.springboot2lj.service.SellerinfoService;
import com.ecology.springboot2lj.utiles.CookieUtil;
import com.ecology.springboot2lj.utiles.ImgValidateCodeUtil;
import com.ecology.springboot2lj.utiles.ResponseCode;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 用户登录
 */
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 没有登录状态下，会跳转到登录页面。
     * @param username
     * @param password
     * @param request
     * @param map
     * @return
     */
    @GetMapping({"/","/index","/login"})
    public ModelAndView index(String username,
                              String password,
                              HttpServletRequest request,
                              Map<String, Object> map){
        ModelAndView modelAndView = new ModelAndView();
        String sessionId = request.getSession().getId();
        //判断当前是否已经登录过了,
        String tokenRedis = redisTemplate.opsForValue().get(sessionId);
        if (tokenRedis!=null||tokenRedis==""){

            modelAndView.setViewName("/index");

            return modelAndView;
        }

        //生成验证码
        //初始化一个map
        Map<String, String> result = Maps.newHashMap();
        try {
            // 获取 4位数验证码
            result= ImgValidateCodeUtil.getImgCodeBaseCode(4);
            //log.info("生成图片验证码 : {}", result);
            // 将验证码存入redis 中（有效时长5分钟）
            setImgCodeCache(result);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        modelAndView.setViewName("/login");
        modelAndView.addObject("result",result);
        modelAndView.addObject("passwordErr","");
        modelAndView.addObject("imgCodeErr","");
        return modelAndView;
    }

    /**
     * 登录功能，用户设置进redis，有时效性
     * @param username
     * @param password
     * @param request
     * @param map
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("imgCode") String imgCode,
                        String imgCodeKey,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Map<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView();

        //1.判断验证码是否过期和是否正确
        String cacheCode = redisTemplate.opsForValue().get(imgCodeKey);
        if (null == cacheCode) {
            modelAndView.setViewName("/login");
            modelAndView.addObject("imgCodeErr","验证码为空");
            return modelAndView;
        }
        //2.验证码验证通过后
        if (cacheCode.equals(imgCode.toLowerCase())) {
            String sessionId = request.getSession().getId();
            //3.判断当前是否已经登录过了,
            String tokenRedis = redisTemplate.opsForValue().get(sessionId);
            if (tokenRedis!=null||tokenRedis==""){
                if(tokenRedis.equals(username+password)){
                    modelAndView.setViewName("/index");
                    return modelAndView;
                }
            }
            //4. 如果没有登陆过，和数据库里的登录密码匹配
            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            List<Login> logins = loginService.queryAll(login);
            //密码错误
            if (logins.size()<1) {
                modelAndView.setViewName("/login");
                modelAndView.addObject("passwordErr","密码错误" );
                return modelAndView;
            }
            //设置token至redis
            String token = UUID.randomUUID().toString();
            //redis过期时间
            Integer expire = RedisConstant.EXPIRE;

            redisTemplate.opsForValue().set(sessionId, username+password, expire, TimeUnit.SECONDS);
            //3. 设置token至cookie,这里暂时没有用到
            CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
            modelAndView.setViewName("/index");
            return modelAndView;
        }else {
            //生成验证码
            //初始化一个map
            Map<String, String> result = Maps.newHashMap();
            try {
                // 获取 4位数验证码
                result= ImgValidateCodeUtil.getImgCodeBaseCode(4);
                //log.info("生成图片验证码 : {}", result);
                // 将验证码存入redis 中（有效时长5分钟）
                setImgCodeCache(result);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
            modelAndView.setViewName("/login");
            modelAndView.addObject("result",result);
            modelAndView.addObject("imgCodeErr","验证码错误或则验证码超时");
            modelAndView.addObject("passwordErr","");
            return modelAndView;
        }


    }

    /**
     * 退出功能暂未完成
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        String sessionId = request.getSession().getId();
        Boolean isLogout = redisTemplate.delete(sessionId);
        ModelAndView modelAndView = new ModelAndView();

        //生成验证码
        //初始化一个map
        Map<String, String> result = Maps.newHashMap();
        try {
            // 获取 4位数验证码
            result= ImgValidateCodeUtil.getImgCodeBaseCode(4);
            //log.info("生成图片验证码 : {}", result);
            // 将验证码存入redis 中（有效时长5分钟）
            setImgCodeCache(result);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        modelAndView.setViewName("/login");
        modelAndView.addObject("result",result);
        modelAndView.addObject("imgCodeErr","");
        modelAndView.addObject("passwordErr","");
        return modelAndView;

    }

    /**
     * 将验证码存入redis 中
     * @param result
     */
    private void setImgCodeCache(Map<String, String> result) {
        String imgCode = result.get("imgCode");
        UUID randomUUID = UUID.randomUUID();
        String imgCodeKey = randomUUID.toString();
        System.out.println("imgCodeKey:" + imgCodeKey);
        // 图片验证码有效时间 ：5 分钟
        redisTemplate.opsForValue().set(imgCodeKey, imgCode, 5, TimeUnit.MINUTES);
        result.put("imgCodeKey", imgCodeKey);
    }
}
