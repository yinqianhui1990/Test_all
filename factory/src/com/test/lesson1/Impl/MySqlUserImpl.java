package com.test.lesson1.Impl;

import com.test.lesson1.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class MySqlUserImpl implements Iuser{
    @Override
    public void save() {
        System.out.println("mysql save!");
    }

    @Override
    public void selectUser() {
        System.out.println("mysql select!");
    }
}
