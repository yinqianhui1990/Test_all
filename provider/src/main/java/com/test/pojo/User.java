package com.test.pojo;

import java.io.Serializable;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/2.
 */
public class User implements Serializable{
    private String userName;
    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
