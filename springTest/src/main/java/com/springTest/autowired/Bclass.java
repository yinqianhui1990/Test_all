package com.springTest.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/6/9.
 */
@Component
public class Bclass {
    @Autowired
    TestA testA;

    public void testB(){
        System.out.println("Bclsss："+testA);
        testA.print();
        testA.setData(456);
        testA.print();
    }
}
