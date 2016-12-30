package com.test.main;

import com.test.aop.DemoInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ThinkPad on 2016/5/3.
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext context=  new ClassPathXmlApplicationContext( "spring-test.xml" );
        // 这里代理的是接口，要不会报类型转化异常的错误哦。不是 demo 而是 DemoInterface 接口。
        DemoInterface demo=(DemoInterface) context.getBean( "demo" );
        demo.sava( "aa" );
        demo.getName();
        demo.update("yin","chen");
}
}
