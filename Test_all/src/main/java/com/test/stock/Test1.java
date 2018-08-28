package com.test.stock;

/**
 * Created by ThinkPad on 2017/1/5.
 */
public class Test1 {

    public static double caculate(double principal,int days){
        double counts=principal;
        double bit=0;
        for (int i = 0; i < days; i++) {
            bit=i%2==0?Math.random()/100:Math.random()/100*-1;
            counts=counts*(1+bit);
        }
        return counts;
    }

    public static void main(String[] args) {
        int zhuan=0;
        int pei=0;
        for (int i = 0; i < 100000; i++) {
            double mon=caculate(10000, 365);
            //System.out.println(mon);
            System.out.println( mon>=10000?zhuan++:pei++);
        }
        System.out.println("赚："+zhuan+"----赔："+pei);

    }
}
