package com.test.service;

import com.test.model.User;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/7/25.
 */
public interface UserService {
    public int addUser(User user);

    /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
    public List<User> findAllUser(int pageNum, int pageSize);
}
