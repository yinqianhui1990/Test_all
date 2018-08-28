package com.test.lesson2.Impl;

import com.test.lesson2.Iuser;

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
