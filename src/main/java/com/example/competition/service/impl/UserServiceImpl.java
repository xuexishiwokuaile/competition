package com.example.competition.service.impl;

import com.example.competition.dao.UserDao;
import com.example.competition.exception.AddException;
import com.example.competition.exception.DeleteException;
import com.example.competition.exception.SelectException;
import com.example.competition.exception.UpdateException;
import com.example.competition.model.User;
import com.example.competition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        userDao.add(user);
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
    public User findOneById(int id) throws SelectException {
        return userDao.findOneById(id);
    }

    @Override
    public User findOneByName(String name) throws SelectException {
        return userDao.findOneByName(name);
    }

    @Override
    public List<User> findAll() throws SelectException {
        return userDao.findAll();
    }
}