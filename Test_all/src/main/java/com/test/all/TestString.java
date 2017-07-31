package com.test.all;

/**
 * Created by ThinkPad on 2017/2/21.
 */
public class TestString {
    public static void main(String[] args) {
        String a="";
       // a.split("134");
        int x=a.indexOf(",");
        try {
            int c = 9 / 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        String b=a.substring(0,0);
        System.out.println("==="+b);
    }
}
