package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.entity.User;
import com.ecology.springboot2lj.service.UserService;
import com.ecology.springboot2lj.utiles.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/excel/export")
public class ExcelExportController {
    @Autowired
    private UserService userService;

    /**
     * 导出user表数据为Excel文件
     * @param response
     */
    @GetMapping("/exportExcel")
    public void export(HttpServletResponse response) {
        System.out.println(1);
        // 模拟从数据库获取需要导出的数据
        List<User> personList = userService.queryAll(null);
        // 导出操作
        ExcelUtiles.exportExcel(personList, "easypoi导出功能", "导出sheet1", User.class, "测试user.xls", response);
    }
}
