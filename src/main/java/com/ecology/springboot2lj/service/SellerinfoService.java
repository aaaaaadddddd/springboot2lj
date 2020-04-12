package com.ecology.springboot2lj.service;

import com.ecology.springboot2lj.entity.Sellerinfo;
import java.util.List;

/**
 * (Sellerinfo)表服务接口
 *
 * @author makejava
 * @since 2020-04-12 11:03:37
 */
public interface SellerinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sellerinfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sellerinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sellerinfo 实例对象
     * @return 实例对象
     */
    Sellerinfo insert(Sellerinfo sellerinfo);

    /**
     * 修改数据
     *
     * @param sellerinfo 实例对象
     * @return 实例对象
     */
    Sellerinfo update(Sellerinfo sellerinfo);

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
     * @param sellerinfo 实例对象
     * @return 对象列表
     */
    List<Sellerinfo> queryAll(Sellerinfo sellerinfo);

}