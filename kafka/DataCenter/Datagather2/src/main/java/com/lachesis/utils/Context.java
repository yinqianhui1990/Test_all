package com.lachesis.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ThinkPad on 2016/8/22.
 */
public class Context {

    private static ApplicationContext context=null;
    public  static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        }
        return context;
    }
}
