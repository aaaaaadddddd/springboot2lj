package com.ecology.springboot2lj.service.impl;

import com.ecology.springboot2lj.entity.Sellerinfo;
import com.ecology.springboot2lj.dao.SellerinfoDao;
import com.ecology.springboot2lj.service.SellerinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sellerinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-12 11:03:37
 */
@Service("sellerinfoService")
public class SellerinfoServiceImpl implements SellerinfoService {
    @Resource
    private SellerinfoDao sellerinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sellerinfo queryById(Integer id) {
        return this.sellerinfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sellerinfo> queryAllByLimit(int offset, int limit) {
        return this.sellerinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sellerinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Sellerinfo insert(Sellerinfo sellerinfo) {
        this.sellerinfoDao.insert(sellerinfo);
        return sellerinfo;
    }

    /**
     * 修改数据
     *
     * @param sellerinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Sellerinfo update(Sellerinfo sellerinfo) {
        this.sellerinfoDao.update(sellerinfo);
        return this.queryById(sellerinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sellerinfoDao.deleteById(id) > 0;
    }

    @Override
    public List<Sellerinfo> queryAll(Sellerinfo sellerinfo) {
        return this.sellerinfoDao.queryAll(sellerinfo);
    }
}