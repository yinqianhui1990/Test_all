package com.test.all;

import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        Calendar nowTime = Calendar.getInstance();
        //nowTime.setTime(null);
      //  System.out.println(nowTime.getTime());

        int num=5;
        test(num);
        System.out.println(num);
        num=test2(num);
        System.out.println(num);
        String str="yinqian";
        test3(str);
        System.out.println(str);

        String[] array = new String[] {"huixin"};
        System.out.println("调用reset方法前array中的第0个元素的值是:" + array[0]);
        reset(array);
        System.out.println("调用reset方法后array中的第0个元素的值是:" + array[0]);

        User user=new User();
        user.setName("qianhui");
        user.setPwd("111111");
        test4(user);
        System.out.println(user.getName()+user.getPwd());
    }

    public static void test(int a){
        a=10;
    }
    public static int  test2(int a){
        a=10;
        return  a;
    }
    public static void test3(String  a){
        a=a+"hello";
    }
    public static void reset(String[] param) {
        param[0] = "hello, world!";
    }
    public static void test4(User a){
        a.setName("mm");
        a.setPwd("123");
    }

}
