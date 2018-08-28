package com.test.lesson2.client;

import com.test.lesson2.Impl.MySqlUserImpl;
import com.test.lesson2.Iuser;
import com.test.lesson2.UserFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client1 {
    public static void main(String[] args) {
        //不直接new 了
        Iuser user= UserFactory.createUser("mysql");
        user.selectUser();
    }
}
