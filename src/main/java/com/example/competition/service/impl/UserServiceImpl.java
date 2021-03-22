package com.example.competition.service.impl;

import com.example.competition.dao.UserDao;
import com.example.competition.exception.AddException;
import com.example.competition.exception.DeleteException;
import com.example.competition.exception.UpdateException;
import com.example.competition.model.User;
import com.example.competition.service.UserService;
import com.example.competition.util.MD5Util;
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
                || StringFormatUtil.hasEmpty(user.getPassword())) {
            throw new AddException("添加用户错误：信息含空");
        } else if (!StringFormatUtil.isPhoneNum(user.getPhone())) {
            throw new AddException("添加用户错误：手机号格式不正确");
        }

        int result;
        try {
            // 密码使用MD5加密
            user.setPassword(MD5Util.md5(user.getPassword()));
            result = userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AddException("添加用户错误，数据库错误");
        }

        if (result > 0) {
            System.out.println("添加用户成功");
        }
    }

    @Override
    public void delete(int id) throws DeleteException {
        if (userDao.findOneById(id) == null) {
            throw new DeleteException("删除用户错误：用户为空");
        }

        int result;
        try {
            result = userDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DeleteException("删除用户错误，数据库错误");
        }

        if (result > 0) {
            System.out.println("删除用户成功");
        }
    }

    /**
     * 这里的update只能修改用户的基本信息，不能修改密码
     */
    @Override
    public void update(User user) throws UpdateException {
        if (user == null) {
            throw new UpdateException("更新用户错误：未提供用户");
        } else if (userDao.findOneByName(user.getName()) != null) {
            throw new UpdateException("更新用户错误：用户名称重复");
        } else if (StringFormatUtil.hasEmpty(user.getName())) {
            throw new UpdateException("更新用户错误：信息含空");
        } else if (!StringFormatUtil.isPhoneNum(user.getPhone())) {
            throw new UpdateException("更新用户错误：手机号格式不正确");
        }

        int result;
        try {
            result = userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UpdateException("更新用户错误，数据库错误");
        }

        if (result > 0) {
            System.out.println("更新用户成功");
        }
    }

    @Override
    public void updatePassword(User user) throws UpdateException {
        if (user == null) {
            throw new UpdateException("更新用户密码错误：未提供用户");
        } else if (StringFormatUtil.hasEmpty(user.getPassword())) {
            throw new UpdateException("更新用户密码错误：密码含空");
        }

        int result;
        try {
            // 使用MD5加密用户修改的密码
            user.setPassword(MD5Util.md5(user.getPassword()));
            result = userDao.updatePassword(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UpdateException("更新用户密码错误，数据库错误");
        }

        if (result > 0) {
            System.out.println("更新用户密码成功");
        }
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