package com.test.generator;


/**
 * Created by ThinkPad on 2016/4/21.
 */
public class test {

   /// @Test
    public  static void main(String []args){
        String str = "001234sa034120";
        String newStr = str.replaceAll("^(0+)", "");
        System.out.println(newStr);
    }
}
