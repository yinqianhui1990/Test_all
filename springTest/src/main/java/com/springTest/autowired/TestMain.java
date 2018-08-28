package com.springTest.autowired;

import com.springTest.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import sun.awt.windows.ThemeReader;

import javax.annotation.PostConstruct;

/**
 * Created by ThinkPad on 2017/6/9.
 */
@Component
public class TestMain {

    @Autowired
    Aclass aclass;
    @Autowired
    Bclass bclass;
   /* @PostConstruct
    public void init(){
        aclass.testA();
        bclass.testB();
        aclass.testA();
        new Thread(new Runnable() {
            public void run() {
                System.out.println("xxxy");
                bclass.testB();
            }
        });
    }*/

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
       // Student student = (Student) applicationContext.getBean("student");
    }

}
