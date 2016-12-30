package com.spring.aop.dao;

import com.spring.aop.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@Component
public class UserDao {
    public User getUser(String id){
        return  new User();
    }
    public int  saveUser(String id){
        return  1;
    }

}
