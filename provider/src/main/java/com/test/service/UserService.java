package com.test.service;

import com.test.pojo.User;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/2.
 */
public interface UserService {
    public User findUserByName(String name);
}
