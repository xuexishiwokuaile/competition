package com.example.competition.controller;

import com.example.competition.exception.AddException;
import com.example.competition.model.User;
import com.example.competition.service.UserService;
import com.example.competition.util.MD5Util;
import com.example.competition.util.ReturnMsgUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @param user 用户
     * @return com.example.competition.util.ReturnMsgUtil
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReturnMsgUtil add(@RequestBody User user) {
        try {
            user.setPassword(MD5Util.md5(user.getPassword()));
            userService.add(user);
            return new ReturnMsgUtil(0, "success");
        } catch (AddException e) {
            return new ReturnMsgUtil(1, e.getMessage());
        }
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return com.example.competition.model.User
     */
    @RequestMapping(value = "/findOneById", method = RequestMethod.GET)
    public User findOneById(@RequestParam(value = "id") int id) {
        return userService.findOneById(id);
    }

    /**
     * 根据name查找用户
     *
     * @param name 用户name
     * @return com.example.competition.model.User
     */
    @RequestMapping(value = "/findOneByName", method = RequestMethod.GET)
    public User findOneByName(@RequestParam(value = "name") String name) {
        return userService.findOneByName(name);
    }

    /**
     * 查找所有用户
     *
     * @param
     * @return java.util.List<com.example.competition.model.User>
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMsgUtil login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), MD5Util.md5(user.getPassword()));
        try {
            subject.login(token);
            return new ReturnMsgUtil(1, "登录成功");
        } catch (Exception e) {
            return new ReturnMsgUtil(0, "登录失败");
        }
    }
}