package com.spring.aop.service;

import com.spring.aop.dao.UserDao;
import com.spring.aop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User getUser(String id){
        return  userDao.getUser(id);
    }
    public boolean  saveUser(String id,String name){
        return  userDao.saveUser(id,name)==1;
    }
}
