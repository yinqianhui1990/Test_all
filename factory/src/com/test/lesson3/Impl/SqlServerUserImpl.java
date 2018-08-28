package com.test.lesson3.Impl;

import com.test.lesson3.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class SqlServerUserImpl implements Iuser{
    @Override
    public void save() {
        System.out.println("sqlserver save!");
    }

    @Override
    public void selectUser() {
        System.out.println("sqlserver select");
    }
}
