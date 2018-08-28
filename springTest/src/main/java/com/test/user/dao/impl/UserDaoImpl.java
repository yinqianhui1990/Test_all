package com.test.user.dao.impl;

import com.test.user.dao.UserDao;
import com.test.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
@Repository
public class UserDaoImpl implements UserDao{

    //均还没实现
    public int insertUser(User user) {
        return 0;
    }

    public User getUser(String id) {
        return null;
    }
}
