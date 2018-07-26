package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.mapper.UserMapper;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/7/25.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }
}
