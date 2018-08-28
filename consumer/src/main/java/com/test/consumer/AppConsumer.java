package com.test.consumer;

import com.test.pojo.User;
import com.test.service.DemoService;
import com.test.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppConsumer
{
    public static void main( String[] args )throws  Exception
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"appcfg.xml"});
        context.start();
        DemoService ds=(DemoService)context.getBean("demoService");
        String str= ds.sayHello("yinqianhui");
        System.out.println(str);

        //userService diaoyong
        UserService userService=(UserService)context.getBean("userService");
        User user=userService.findUserByName("刘德华");
        System.out.println(user.getUserName()+":"+user.getPassword());
        System.in.read();
    }
}
