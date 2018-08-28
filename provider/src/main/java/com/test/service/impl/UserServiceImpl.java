package com.test.service.impl;

import com.test.pojo.User;
import com.test.service.UserService;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/2.
 */
public class UserServiceImpl implements UserService{
    public User findUserByName(String name) {
        User user =new User();
        user.setUserName(name);
        user.setPassword("123456");
        return user;
    }
}
