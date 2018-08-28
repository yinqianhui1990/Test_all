package com.test.thread.safe;

import java.util.Random;

/**
 * Created by ThinkPad on 2017/3/10.
 */
public class ThreadLocalTest {
    static  ThreadLocal <Integer> localCount=new ThreadLocal<Integer>();
    //线程独享该变量的副本，而并不影响其他线程获取该数据，即2个线程对该变量的操作互不影响，
    //适用于数据库连接管理，session管理等等，
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                public void run() {
                    Random random = new Random();
                    int count= random.nextInt(1000);
                    localCount.set(count);
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
            System.out.println("进入a模块："+Thread.currentThread()+":"+localCount.get());
        }
    }
}
