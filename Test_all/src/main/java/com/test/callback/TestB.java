package com.test.callback;

/**
 * Created by ThinkPad on 2017/4/19.
 */
public class TestB {
    public void helpSay(String title,callInterface callInterface)throws Exception{
        System.out.println("正在组织语言。。。。"+title);
        Thread.sleep(5000);
        System.out.println("正在演讲...."+title);
        callInterface.sayFinish(title);
    }
}
