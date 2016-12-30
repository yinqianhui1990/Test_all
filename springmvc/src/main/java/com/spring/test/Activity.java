package com.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2016/8/22.
 */
@Component
public class Activity {

    @Autowired
    private  User user;

    public void play(){
        user.sing();
    }
}
