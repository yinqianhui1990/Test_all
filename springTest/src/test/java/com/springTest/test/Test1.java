package com.springTest.test;

import com.springTest.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {
    @Autowired
    Student student;
    @Test
    public void printInfo() {
        System.out.println("name:"+student.getName());
        System.out.println("id:"+student.getId());
        System.out.println("class:"+student.getClazz());
    }
}
