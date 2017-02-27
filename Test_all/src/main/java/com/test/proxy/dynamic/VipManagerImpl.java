package com.test.proxy.dynamic;

import com.test.proxy.dynamic.UserManager;

/**
 * Created by ThinkPad on 2017/2/27.
 */
public class VipManagerImpl implements UserManager {
    public void addUser(String name,String passWord) {
        System.out.println("添加VIP用户成功");
    }
}
