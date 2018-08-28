package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.pojo.User;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user) {
        return userDao.insertUser(user)==1?true:false;
    }

    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
