package com.ecology.springboot2lj.dao;

import com.ecology.springboot2lj.entity.Sellerinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Sellerinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-12 11:03:37
 */
@Mapper
public interface SellerinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sellerinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sellerinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sellerinfo 实例对象
     * @return 对象列表
     */
    List<Sellerinfo> queryAll(Sellerinfo sellerinfo);

    /**
     * 新增数据
     *
     * @param sellerinfo 实例对象
     * @return 影响行数
     */
    int insert(Sellerinfo sellerinfo);

    /**
     * 修改数据
     *
     * @param sellerinfo 实例对象
     * @return 影响行数
     */
    int update(Sellerinfo sellerinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}