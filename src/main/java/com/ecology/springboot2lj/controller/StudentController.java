package com.ecology.springboot2lj.controller;

import com.ecology.springboot2lj.annotation.InsertLog;
import com.ecology.springboot2lj.aspect.LogAspect;
import com.ecology.springboot2lj.entity.Student;
import com.ecology.springboot2lj.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-04-08 21:10:16
 */
@RestController
@RequestMapping("student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger("StudentController");

    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

    /**
     * 保存student
     * @param student
     * @return
     */
    @InsertLog(logStr="保存了一条数据")
    @PutMapping("insert")
    public Student insert(@RequestBody Student student){
        if (student!=null){
            logger.info("student66:"+student.getName());
            Student insert = studentService.insert(student);
            return student;
        }
        return null;

    }

}