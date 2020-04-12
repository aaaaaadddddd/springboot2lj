package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.entity.Sellerinfo;
import com.ecology.springboot2lj.service.SellerinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sellerinfo)表控制层
 *
 * @author makejava
 * @since 2020-04-12 11:03:37
 */
@RestController
@RequestMapping("sellerinfo")
public class SellerinfoController {
    /**
     * 服务对象
     */
    @Resource
    private SellerinfoService sellerinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sellerinfo selectOne(Integer id) {
        return this.sellerinfoService.queryById(id);
    }

}