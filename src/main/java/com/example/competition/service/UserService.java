package com.example.competition.service;

import com.example.competition.exception.AddException;
import com.example.competition.exception.DeleteException;
import com.example.competition.exception.SelectException;
import com.example.competition.exception.UpdateException;
import com.example.competition.model.User;

import java.util.List;
import java.util.Set;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public interface UserService {
    /**
     * 添加一个新用户
     *
     * @param user 目标用户
     * @return void
     * @throws AddException 添加异常
     */
    void add(User user) throws AddException;

    /**
     * 删除已有的用户
     *
     * @param id 用户id
     * @return void
     * @throws DeleteException 删除异常
     */
    void delete(int id) throws DeleteException;

    /**
     * 更新已有的用户
     *
     * @param user 更新的用户
     * @return void
     * @throws UpdateException 更新异常
     */
    void update(User user) throws UpdateException;

    /**
     * 根据id查找用户
     *
     * @param id 目标id
     * @return user 用户
     * @throws SelectException 查询异常
     */
    User findOneById(int id);

    /**
     * 根据name查找用户
     *
     * @param name 目标name
     * @return user 用户
     * @throws SelectException 查询异常
     */
    User findOneByName(String name);

    /**
     * 查找所有用户
     *
     * @param
     * @return com.example.competition.model.User
     */
    List<User> findAll();

    public Set<String> findRoles(String name);

    public Set<String> findPermissions(String name);
}
