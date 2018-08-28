package com.test.callback;

/**
 * Created by ThinkPad on 2017/4/19.
 */
public class TestA implements callInterface {
    public void say(String title) throws Exception{
       TestB testB=new TestB();    //TestB代理演讲
        testB.helpSay(title,this);
    }
    public void sayFinish(String title) {
        System.out.println(title+"演讲完成");
    }

    public static void main(String[] args) throws Exception{
        TestA testA=new TestA();
        testA.say("sb");

    }
}
