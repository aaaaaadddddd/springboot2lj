package com.ecology.springboot2lj.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSONObject;
import com.ecology.springboot2lj.entity.User;
import com.ecology.springboot2lj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/excel/import")
@Slf4j
public class ExcelImportController {

    @Autowired
    private UserService userService;

    @PostMapping("/importExcel")
    public String importExcel2(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class,
                    importParams);
            List<User> userList = result.getList();
            for (User user : userList) {
                userService.insert(user);
            }
            log.info("从Excel导入数据一共 {} 行 ", userList.size());
        } catch (IOException e) {
            log.error("导入失败：{}", e.getMessage());
        } catch (Exception e1) {
            log.error("导入失败：{}", e1.getMessage());
        }
        return "导入成功";
    }
}
