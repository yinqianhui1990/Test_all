package com.test.aop;

/**
 * Created by ThinkPad on 2016/5/3.
 */
public class Demo  implements DemoInterface{
    public String getName() {

        return "fish" ;

    }

    public void sava(String myName) {

        System. out .println( " 这是一个保存方法 " );

    }

    public void update(String myName, String heName) {

        System. out .println( " 这是一个更新方法 " );

    }
}
