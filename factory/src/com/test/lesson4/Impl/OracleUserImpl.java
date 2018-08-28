package com.test.lesson4.Impl;

import com.test.lesson4.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class OracleUserImpl implements Iuser {
    @Override
    public void save() {
        System.out.println("oracle USER save!");
    }

    @Override
    public void selectUser() {
        System.out.println("oracle USER select!");
    }
}
