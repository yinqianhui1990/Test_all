package com.test.singleton.lesson1;

/**
 * Created by ThinkPad on 2017/3/21.
 * 适用于单线程下
 */
public class Single1 {
    private Single1() {
        System.out.println("once time！");
    }
    private static Single1 single;
    public static Single1 getInstance(){
        if(single==null){
            single=new Single1();
        }
        return single;
    }
}
