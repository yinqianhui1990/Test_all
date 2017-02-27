package com.test.proxy.staticProxy;

/**
 * Created by ThinkPad on 2017/2/27.
 */
public class Client {
    public static void main(String[] args) {
       // UserManager userManager=new UserManagerProxy(new UserManagerImpl());
        UserManager userManager=new UserManagerProxy(new VipManagerImpl());
        userManager.addUser();
    }
}
