package com.spring.test;

import org.springframework.context.ApplicationContext;

/**
 * Created by ThinkPad on 2016/8/22.
 */
public class Test {

    public static void main( String[] args ) {
        ApplicationContext app= Context.getApplicationContext();
        User user=(User)app.getBean("user");
        user.sing();
        Activity activity=(Activity)app.getBean("activity");
                //new Activity();
        activity.play();

    }
}
