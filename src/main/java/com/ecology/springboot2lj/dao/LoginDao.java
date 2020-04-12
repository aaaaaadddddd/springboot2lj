package com.ecology.springboot2lj.dao;

import com.ecology.springboot2lj.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Login)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-12 20:35:53
 */
@Mapper
public interface LoginDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Login queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Login> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param login 实例对象
     * @return 对象列表
     */
    List<Login> queryAll(Login login);

    /**
     * 新增数据
     *
     * @param login 实例对象
     * @return 影响行数
     */
    int insert(Login login);

    /**
     * 修改数据
     *
     * @param login 实例对象
     * @return 影响行数
     */
    int update(Login login);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}