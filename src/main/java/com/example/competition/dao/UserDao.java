package com.example.competition.dao;

import com.example.competition.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Insert("INSERT INTO user (`id`, `name`, `password`, `phone`, `status`) " +
            "VALUES (#{id}, #{name}, #{password}, #{phone}, 0)")
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
            "name = #{name}, password = #{password}, phone = #{phone} " +
            "WHERE id = #{id}")
    int update(User user);

    /**
     * 通过id查找一个用户
     *
     * @param id 用户ID
     * @return user 目标用户
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findOneById(String id);

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
}
