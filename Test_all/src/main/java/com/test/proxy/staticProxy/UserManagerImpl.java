package com.test.proxy.staticProxy;

/**
 * Created by ThinkPad on 2017/2/27.
 */
public class UserManagerImpl implements UserManager {
    public void addUser() {
        System.out.println("添加普通用户成功");
    }
}
