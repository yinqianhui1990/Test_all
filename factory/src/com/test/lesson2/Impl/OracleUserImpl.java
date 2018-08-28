package com.test.lesson2.Impl;

import com.test.lesson2.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class OracleUserImpl implements Iuser {
    @Override
    public void save() {
        System.out.println("oracle save!");
    }

    @Override
    public void selectUser() {
        System.out.println("oracle select!");
    }
}
