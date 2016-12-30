package com.springTest.test;

import com.springTest.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ThinkPad on 2016/11/11.
 */
public class TestBean {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=(Student)applicationContext.getBean("student");
        System.out.println("name:"+student.getName());
        System.out.println("id:"+student.getId());
        System.out.println("class:"+student.getClazz());
    }
}
