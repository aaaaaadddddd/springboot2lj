package com.ecology.springboot2lj.service.impl;

import com.ecology.springboot2lj.entity.Login;
import com.ecology.springboot2lj.dao.LoginDao;
import com.ecology.springboot2lj.entity.Sellerinfo;
import com.ecology.springboot2lj.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Login)表服务实现类
 *
 * @author makejava
 * @since 2020-04-12 20:35:53
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Login queryById(Integer id) {
        return this.loginDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Login> queryAllByLimit(int offset, int limit) {
        return this.loginDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param login 实例对象
     * @return 实例对象
     */
    @Override
    public Login insert(Login login) {
        this.loginDao.insert(login);
        return login;
    }

    /**
     * 修改数据
     *
     * @param login 实例对象
     * @return 实例对象
     */
    @Override
    public Login update(Login login) {
        this.loginDao.update(login);
        return this.queryById(login.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.loginDao.deleteById(id) > 0;
    }

    @Override
    public List<Login> queryAll(Login login) {
        return this.loginDao.queryAll(login);
    }
}