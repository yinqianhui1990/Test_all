package com.test.value_test;

/**
 * Created by ThinkPad on 2017/8/14.
 */
public class TestMain {

    public int dec(int a){
        a=a-1;
        return a;
    }

    public String adds(String a){
        a=a+"ok";
        return a;
    }

    public User testUser(User a){
        a.setName("niuniu");
        return a;
    }

    public static void main(String[] args) {
        int b=10;
        TestMain testMain=new TestMain();
        //基本数据类型作为参数传入，不会影响其原来的值
        testMain.dec(b);
        System.out.println(b);
        //-----------------------
        String c="abc";
        testMain.adds(c);
        System.out.println(c);
        ////-----------------------引用类型,当做参数传入后会被改变----------------
        User user=new User("yin","123");
        testMain.testUser(user);
        System.out.println(user.toString());
    }
}
