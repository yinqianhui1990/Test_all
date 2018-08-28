package com.test.lesson1.client;

import com.test.lesson1.Impl.MySqlUserImpl;
import com.test.lesson1.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client1 {
    public static void main(String[] args) {
        Iuser user=new MySqlUserImpl();
        user.selectUser();
    }
}
