package com.example.competition.service.impl;

import com.example.competition.dao.UserDao;
import com.example.competition.exception.AddException;
import com.example.competition.exception.DeleteException;
import com.example.competition.exception.UpdateException;
import com.example.competition.model.User;
import com.example.competition.service.UserService;
import com.example.competition.util.StringFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) throws AddException {
        if (user == null) {
            throw new AddException("添加用户错误：未提供用户");
        } else if (userDao.findOneByName(user.getName()) != null) {
            throw new AddException("添加用户错误：用户名称重复");
        } else if (StringFormatUtil.hasEmpty(user.getName())
                || StringFormatUtil.hasEmpty(user.getPassword())
                || StringFormatUtil.hasEmpty(user.getPhone())) {
            throw new AddException("添加用户错误：信息含空");
        }

        int result;
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AddException("添加用户错误：" + e.getMessage());
        }

        if (result > 0) {
            System.out.println("注册成功");
        }
    }

    @Override
    public void delete(int id) throws DeleteException {
        userDao.delete(id);
    }

    @Override
    public void update(User user) throws UpdateException {
        userDao.update(user);
    }

    @Override
    public User findOneById(int id) {
        return userDao.findOneById(id);
    }

    @Override
    public User findOneByName(String name) {
        return userDao.findOneByName(name);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Set<String> findRoles(String name) {
        return userDao.findRoles(name);
    }

    @Override
    public Set<String> findPermissions(String name) {
        return userDao.findPermissions(name);
    }
}