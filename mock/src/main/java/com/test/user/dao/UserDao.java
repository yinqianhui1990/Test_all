package com.test.user.dao;

import com.test.user.pojo.User;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
public interface UserDao {
    public int insertUser(User user);

    public User getUser(String id);
}
