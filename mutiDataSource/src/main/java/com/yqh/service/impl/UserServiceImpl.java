package com.yqh.service.impl;

import com.yqh.dao.UserMapper;
import com.yqh.model.User;
import com.yqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2017/2/22.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
