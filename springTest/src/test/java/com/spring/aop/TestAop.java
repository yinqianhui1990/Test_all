package com.spring.aop;

import com.spring.aop.service.UserService;
import com.springTest.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-aop.xml")
public class TestAop {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        System.out.println(userService.getUser("123"));
        System.out.println(userService.saveUser("123"));
    }
}
