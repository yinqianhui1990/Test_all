package com.test.singleton.lesson1;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Test1 {
    public static void main(String[] args) {
        Single1 single1=Single1.getInstance();
        Single1 single12=Single1.getInstance();
        System.out.println(single1==single12 ?"equal":"not equal");
    }
}
