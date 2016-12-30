package com.test.aop;

/**
 * Created by ThinkPad on 2016/5/3.
 */
public class MyAop {

    public void myMthod1 (){

        System. out .println( " 前置通知 " );

    }

    public void myMthod2(){

        System. out .println( " 后置通知 " );

    }

    public void myMthod3(){

        System. out .println( " 最终通知 " );

    }
}
