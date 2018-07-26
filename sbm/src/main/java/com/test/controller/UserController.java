package com.test.controller;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/7/25.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add")
    public int addUser(){
        User user=new User();
        user.setName("刘德"+Math.random()*1000);
        user.setPassword("123");
        user.setSex("男");
        user.setAge(20);
       return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUser/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public Object  findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
