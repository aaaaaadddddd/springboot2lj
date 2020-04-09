package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.entity.User;
import com.ecology.springboot2lj.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-09 13:26:14
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAll")
    public List<User> queryAll() {
        return this.userService.queryAll(null);
    }

    /**
     * 通过限制条件查询
     * @return
     */
    @GetMapping("queryAllByLimit")
    public List<User> queryAllByLimit() {
        return this.userService.queryAllByLimit(1,3);
    }

}