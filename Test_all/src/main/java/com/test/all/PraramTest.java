package com.test.all;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/11.
 */
public class PraramTest {
    public static void main(String[] args) {
        String a="123";
        test(a);
        System.out.println(a);
        StringBuffer sb=new StringBuffer("123");
        test(sb);
        System.out.println(sb);
        StringBuffer sb1=new StringBuffer("123");
        test1(sb1);
        System.out.println(sb1);
    }
    //�ββ���ı�ʵ�ε�����
    public static void test(String s){
        s="abc";
    }

    //�ββ���ı�ʵ�ε�����
    public static void test1(StringBuffer sb){
        sb=new StringBuffer("abc");
    }

   //�����βλ�ı����õ�ֵ
    public static void test(StringBuffer sb){
        sb.append("abc");
    }
}
