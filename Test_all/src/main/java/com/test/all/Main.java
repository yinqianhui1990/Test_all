package com.test.all;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/11.
 */
public class Main{
    public static void main(String []args){
        String test="    hello      world  ";
        int a=getLastWordLength(test);
        System.out.println(a);
    }

    public static int getLastWordLength(String input){
        String res[]=input.split(" ");
        String last=res[res.length-1];
        return last.length();
    }
}
