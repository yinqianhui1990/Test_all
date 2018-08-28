package com.test.lesson4.factory;

import com.test.lesson4.Iproduct;
import com.test.lesson4.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public interface IFactory {
    public Iuser createUser();
    public Iproduct createProduct();
}
