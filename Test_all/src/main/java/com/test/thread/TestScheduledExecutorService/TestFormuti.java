package com.test.thread.TestScheduledExecutorService;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/5/9.
 */
public class TestFormuti {
    public static void main(String[] args) {
        System.out.println("test...");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ScheduledFuture t1=executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("time:" + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("now:" + new Date());
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
