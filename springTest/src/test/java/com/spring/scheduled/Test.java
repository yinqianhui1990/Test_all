package com.spring.scheduled;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-scheduled.xml")
public class Test {


    @org.junit.Test
    public void test() throws InterruptedException {
        System.out.println("测试开始....");
        Thread.sleep(1000*30);
    }

}
