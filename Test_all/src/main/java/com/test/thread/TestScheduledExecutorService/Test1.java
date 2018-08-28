package com.test.thread.TestScheduledExecutorService;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/4/18.
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService executorTrack = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture t1=executorTrack.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("time:" + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(1000*10);
        //任务取消
        t1.cancel(true);
        Thread.sleep(1000*5);
        executorTrack.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("time22:"+new Date());
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
