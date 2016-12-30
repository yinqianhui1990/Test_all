package com.test.thread;

/**
 * Created by ThinkPad on 2016/11/7.
 */
public class Count implements Runnable{

    public static  int count=0;


    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
            }
        }
    }

   /*  与上相同的效果
   public synchronized  void run() {

            for(int i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
            }

    }*/

    public static  void  main(String[] args){
       /* Count count=new Count();
        Thread t1=new Thread(count,"test1");
        Thread t2=new Thread(count,"test2");
        t1.start();
        t2.start();*/
        Count count=new Count();
        Count count2=new Count();
        Thread t1=new Thread(count,"test1");
        Thread t2=new Thread(count2,"test2");
        t1.start();
        t2.start();
    }
}
