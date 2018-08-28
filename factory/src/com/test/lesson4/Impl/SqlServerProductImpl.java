package com.test.lesson4.Impl;

import com.test.lesson4.Iproduct;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class SqlServerProductImpl implements Iproduct {
    @Override
    public void save() {
        System.out.println("sqlserver Product save!");
    }

    @Override
    public void selectUser() {
        System.out.println("sqlserver Product select");
    }
}
