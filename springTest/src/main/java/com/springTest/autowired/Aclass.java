package com.springTest.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/6/9.
 */
@Component
public class Aclass {
    @Autowired
    TestA testA;

    public void testA(){
        System.out.println("Aclsss："+testA);
        testA.print();
        testA.setData(123);
        testA.print();
    }

}
