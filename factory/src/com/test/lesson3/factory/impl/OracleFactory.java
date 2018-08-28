package com.test.lesson3.factory.impl;

import com.test.lesson3.Impl.OracleUserImpl;
import com.test.lesson3.Iuser;
import com.test.lesson3.factory.IFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class OracleFactory implements IFactory {
    @Override
    public Iuser createUser() {
        return new OracleUserImpl();
    }
}
