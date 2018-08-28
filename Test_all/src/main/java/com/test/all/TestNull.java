package com.test.all;

/**
 * Created by ThinkPad on 2017/8/9.
 */
public class TestNull {
    public static void main(String[] args) {
        String test=null;
        try {
            int a = Integer.valueOf(test);
            System.out.println("---{}:" + a);
        }catch (Exception e){
          e.printStackTrace();
            System.out.println(e.getStackTrace().toString());
        }
    }
}
