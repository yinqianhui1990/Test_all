package com.test.digui;

/**
 * Created by ThinkPad on 2017/3/10.
 */
public class Test {
    //递归法
    public int cacuJiecheng(int n){
        if (n==0) return 1;
        int rs=n*cacuJiecheng(n-1);
        return rs;
    }
    //普通法
    public int cacuJiecheng2(int n){
        int rs=1;
       for (int i=1;i<=n;i++){
           rs=rs*i;
       }
        return rs;
    }

    public static void main(String[] args) {
        Test test=new Test();
       int rs= test.cacuJiecheng(10);
        System.out.println("结果："+rs);
        int rs2= test.cacuJiecheng2(10);
        System.out.println("结果："+rs2);
    }
}
