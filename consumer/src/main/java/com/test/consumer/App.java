package com.test.consumer;

import com.test.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws  Exception
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"appcfg.xml"});
        context.start();
        DemoService ds=(DemoService)context.getBean("demoService");
        String str= ds.sayHello("yinqianhui");
        System.out.println(str);
        System.in.read();
    }
}
