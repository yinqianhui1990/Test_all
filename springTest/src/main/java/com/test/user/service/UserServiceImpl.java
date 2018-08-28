package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public boolean addUser(User user) {
        return userDao.insertUser(user)==1?true:false;
    }

    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
