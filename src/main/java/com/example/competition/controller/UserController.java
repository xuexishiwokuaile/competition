package com.example.competition.controller;

import com.example.competition.exception.AddException;
import com.example.competition.exception.SelectException;
import com.example.competition.model.User;
import com.example.competition.service.UserService;
import com.example.competition.util.ReturnMsgUtil;
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
            System.out.println(user.getName());
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
        try {
            return userService.findOneById(id);
        } catch (SelectException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 根据name查找用户
     *
     * @param name 用户name
     * @return com.example.competition.model.User
     */
    @RequestMapping(value = "/findOneByName", method = RequestMethod.GET)
    public User findOneByName(@RequestParam(value = "name") String name) {
        try {
            return userService.findOneByName(name);
        } catch (SelectException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 查找所有用户
     *
     * @param
     * @return java.util.List<com.example.competition.model.User>
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        try {
            return userService.findAll();
        } catch (SelectException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}