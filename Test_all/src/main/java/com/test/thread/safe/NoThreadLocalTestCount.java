package com.test.thread.safe;

import java.util.Random;

/**
 * Created by ThinkPad on 2017/3/10.
 */
public class NoThreadLocalTestCount {
    static  int count=1;
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                public void run() {
                    Random random = new Random();
                    count= random.nextInt(1000);
                    System.out.println(Thread.currentThread()+":"+count);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    Aclass.test();
                }
            }).start();
        }
    }
    static class Aclass{
        public static void test(){
            System.out.println("进入a模块："+Thread.currentThread()+":"+count);
        }
    }
}
/*
*线程不安全count
Thread[Thread-1,5,main]:487
Thread[Thread-0,5,main]:776
进入a模块：Thread[Thread-1,5,main]:776
Thread[Thread-2,5,main]:862
进入a模块：Thread[Thread-2,5,main]:862
进入a模块：Thread[Thread-0,5,main]:862
* */