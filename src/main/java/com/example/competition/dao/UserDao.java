package com.example.competition.dao;

import com.example.competition.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */

@Repository
public interface UserDao {
    /**
     * 添加一个新用户
     *
     * @param user 目标用户
     * @return int 受影响的行数
     */
    @Insert("INSERT INTO user (`name`, `password`, `phone`, `roleId`,`gender`) " +
            "VALUES (#{name}, #{password}, #{phone}, 0, #{gender})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(User user);

    /**
     * 删除已有的用户
     *
     * @param id 用户id
     * @return int 受影响的行数
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int delete(int id);

    /**
     * 更新已有的用户
     *
     * @param user 目标用户
     * @return int 受影响的行数
     */
    @Update("UPDATE user SET " +
            "name = #{name}, phone = #{phone} " +
            "WHERE id = #{id}")
    int update(User user);

    /**
     * 更新用户密码
     *
     * @param user 用户
     * @return int 受影响的行数
     */
    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    int updatePassword(User user);

    /**
     * 通过id查找一个用户
     *
     * @param id 用户ID
     * @return user 目标用户
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findOneById(int id);

    /**
     * 通过名称查找一个用户
     *
     * @param name 用户名称
     * @return user 目标用户
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findOneByName(String name);

    /**
     * 查找所有用户
     *
     * @param
     * @return java.util.List<com.example.competition.model.User>
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    /**
     * 查找一个用户的所有角色类型
     *
     * @param name 用户name
     * @return java.util.Set<java.lang.String>
     */
    @Select("SELECT `roleName` FROM role, user WHERE user.name = #{name} AND role.roleId = user.roleId")
    Set<String> findRoles(String name);

    /**
     * 查找一个用户允许的操作
     *
     * @param name 用户name
     * @return java.util.Set<java.lang.String>
     */
    @Select("SELECT `permissionName` FROM permission, user WHERE user.name = #{name} AND " +
            "permission.roleId = user.roleId")
    Set<String> findPermissions(String name);
}
