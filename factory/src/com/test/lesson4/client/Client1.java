package com.test.lesson4.client;

import com.test.lesson4.Iuser;
import com.test.lesson4.factory.IFactory;
import com.test.lesson4.factory.impl.ManagerFactory;


/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client1 {
    public static void main(String[] args) {
        IFactory managerFactory=new ManagerFactory();
        Iuser iuser=managerFactory.createUser();
        iuser.save();
        iuser.selectUser();

    }
}
