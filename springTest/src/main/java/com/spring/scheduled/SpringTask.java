package com.spring.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@Component
public class SpringTask {

    @Scheduled(fixedDelay = 5000)
    public void doSomething() {
        System.out.println("每执行完一个任务后隔5秒再执行...");
    }

    @Scheduled(fixedRate = 5000)
    public void doSomething2() {
        System.out.println("每隔5s执行一个任务...");
    }
}
