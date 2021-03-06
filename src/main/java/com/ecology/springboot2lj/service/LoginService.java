package com.ecology.springboot2lj.service;

import com.ecology.springboot2lj.entity.Login;
import com.ecology.springboot2lj.entity.Sellerinfo;

import java.util.List;

/**
 * (Login)表服务接口
 *
 * @author makejava
 * @since 2020-04-12 20:35:53
 */
public interface LoginService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Login queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Login> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param login 实例对象
     * @return 实例对象
     */
    Login insert(Login login);

    /**
     * 修改数据
     *
     * @param login 实例对象
     * @return 实例对象
     */
    Login update(Login login);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param login 实例对象
     * @return 对象列表
     */
    List<Login> queryAll(Login login);

}