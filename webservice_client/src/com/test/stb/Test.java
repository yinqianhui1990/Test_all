package com.test.stb;

/**
 * Created by ThinkPad on 2016/10/26.
 */
public class Test {
    public static void  main(String[] args)throws Exception{
        String sendString="abcdEF1234567890";
        byte[] sendBytes= sendString .getBytes("UTF8");

        String t22=new String(sendBytes,"UTF8");
    }
}
