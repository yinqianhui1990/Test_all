package com.test.user.service;

import com.test.user.pojo.User;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
public interface UserService {
    public boolean addUser(User user);
    public User getUser(String id);
}
