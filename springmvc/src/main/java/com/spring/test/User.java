package com.spring.test;

import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2016/8/22.
 */
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void  sing(){
        System.out.println("I'm sing ...");
    }
}
