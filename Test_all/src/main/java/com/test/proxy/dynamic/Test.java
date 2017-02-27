package com.test.proxy.dynamic;

/**
 * Created by ThinkPad on 2017/2/27.
 */
public class Test {
    public static void main(String[] args) {
        LogHandler logHandler=new LogHandler();
       // UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
       /* UserManager userManager=(UserManager)logHandler.newProxyInstance(new VipManagerImpl());
        userManager.addUser("yin","123456");*/
        BookManager bookManager=(BookManager)logHandler.newProxyInstance(new BookManagerImpl());
        bookManager.addBook();

    }

}
