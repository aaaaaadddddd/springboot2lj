package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.entity.Order;
import com.ecology.springboot2lj.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2020-04-16 11:39:34
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "selectOne",produces = {"application/json; charset=utf-8"})
    public Order selectOne(Integer id) {
        return this.orderService.queryById(id);
    }

}