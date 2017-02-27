package com.test.proxy.staticProxy;


/**
 * Created by ThinkPad on 2017/2/27.
 */
public class UserManagerProxy implements UserManager{
    //目标对象
    protected  UserManager userManager;

    public UserManagerProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    public void addUser() {
        System.out.println("执行添加用户的方法");
        userManager.addUser();
    }
}
