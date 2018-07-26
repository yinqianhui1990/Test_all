package com.test.mapper;

import com.test.model.User;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/7/25.
 */
public interface UserMapper {
    public  int insertUser(User user);
    public List<User> selectAllUser();
}
