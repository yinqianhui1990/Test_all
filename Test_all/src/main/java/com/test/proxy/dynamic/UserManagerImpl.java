package com.test.proxy.dynamic;

/**
 * Created by ThinkPad on 2017/2/27.
 */
public class UserManagerImpl implements UserManager {
    public void addUser(String name,String passWord) {
        System.out.println("添加普通用户成功");
    }
}
