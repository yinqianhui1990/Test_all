package com.test.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"appcfg.xml"});
        context.start();

        System.in.read();
        // 为保证服务一直开着，利用输入流的阻塞来模拟

    }
}
