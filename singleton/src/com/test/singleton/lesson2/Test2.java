package com.test.singleton.lesson2;


/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Test2 {
    static  Single2 singleA=null;
    static  Single2 singleB=null;


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test2.singleA=Single2.getInstance();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test2.singleB=Single2.getInstance();
            }
        }).start();


        System.out.println(singleA==singleB?"equal":"not equal");
    }


}
