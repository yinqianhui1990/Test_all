package com.springTest.autowired.beanFactory;

import com.springTest.autowired.TestA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ThinkPad on 2017/6/19.
 */
@Component
public class TestMain2 {
    @Autowired
    private TestFactory testFactory;
    @PostConstruct
    public void init(){
       TestA testA1= testFactory.getTestA();
        System.out.println("1===="+testA1);
        TestA testA2= testFactory.getTestA();
        System.out.println("2===="+testA2);
        String a="ab";

    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        // Student student = (Student) applicationContext.getBean("student");
    }
}
