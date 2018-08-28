package com.test.lesson3.client;

import com.test.lesson3.Iuser;
import com.test.lesson3.factory.IFactory;
import com.test.lesson3.factory.impl.OracleFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client1 {
    public static void main(String[] args) {
       //œ»”√oracle
        IFactory iFactory =new OracleFactory();
        Iuser iuser= iFactory.createUser();
        iuser.selectUser();
    }
}
