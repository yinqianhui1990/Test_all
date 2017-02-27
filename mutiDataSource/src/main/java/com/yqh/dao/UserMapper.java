package com.yqh.dao;

import com.yqh.model.User;

/**
 * Created by ThinkPad on 2017/2/22.
 */
public interface UserMapper {
    User selectByPrimaryKey(int id);
}
