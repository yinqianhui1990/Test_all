package com.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2017/2/8.
 */
public class TestRun implements Runnable{
    public void run() {
        System.out.println("run。。。");
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorCheckBag = Executors
                .newSingleThreadScheduledExecutor();
        executorCheckBag.scheduleWithFixedDelay(new TestRun(),1,5, TimeUnit.SECONDS);
    }
}
