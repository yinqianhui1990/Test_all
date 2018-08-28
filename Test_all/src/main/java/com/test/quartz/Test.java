package com.test.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Date;

/**
 * Created by ThinkPad on 2017/2/13.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        JobDetail jobDetail=new JobDetail("job1","jobGroup1",TestQuartz.class);
        SimpleTrigger simpleTrigger=new SimpleTrigger("tri1","triGroup1");
        simpleTrigger.setStartTime(new Date());
        simpleTrigger.setRepeatInterval(1000);
        simpleTrigger.setRepeatCount(1000);
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler=schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        scheduler.start();
    }


}
