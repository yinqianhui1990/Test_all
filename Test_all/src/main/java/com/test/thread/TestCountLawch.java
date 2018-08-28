package com.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ThinkPad on 2017/2/6.
 * Java的concurrent包里面的CountDownLatch其实可以把它看作一个计数器，
 * 只不过这个计数器的操作是原子操作，同时只能有一个线程去操作这个计数器，
 * 也就是同时只能有一个线程去减这个计数器里面的值。
 你可以向CountDownLatch对象设置一个初始的数字作为计数值，
 任何调用这个对象上的await()方法都会阻塞，直到这个计数器的计数值被其他的线程减为0为止。
 CountDownLatch的一个非常典型的应用场景是：有一个任务想要往下执行，
 但必须要等到其他的任务执行完毕后才可以继续往下执行。假如我们这个想要
 继续往下执行的任务调用一个CountDownLatch对象的await()方法，其他的任务
 执行完自己的任务后调用同一个CountDownLatch对象上的countDown()方法，
 这个调用await()方法的任务将一直阻塞等待，直到这个CountDownLatch对象的计数值减到0为止。
 */
public class TestCountLawch implements  Runnable{
    private CountDownLatch downLatch=new CountDownLatch(5);
    public void run() {
        synchronized (this) {
            try {
                System.out.println("1");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("2");
        }
        downLatch.countDown();
    }

    public CountDownLatch getDownLatch() {
        return downLatch;
    }

    public void setDownLatch(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public static void main(String[] args) throws Exception{
        TestCountLawch testCountLawch=  new TestCountLawch();
        for(int i=0;i<5;i++) {
            Thread thread = new Thread(testCountLawch);
            thread.start();
        }
        testCountLawch.getDownLatch().await();
        System.out.println("完成");
    }
}
