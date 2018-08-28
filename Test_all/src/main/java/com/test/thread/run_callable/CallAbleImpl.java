package com.test.thread.run_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/8/30.
 */
public class CallAbleImpl implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("正在执行call方法内容....");
        Thread.sleep(3000);
        System.out.println("执行call方法完成....");
        return 0;
    }

    public static void main(String[] args) throws  Exception{
        CallAbleImpl callAble=new CallAbleImpl();
        FutureTask<Integer> task = new FutureTask(callAble);
        Thread thread=new Thread(task);
        thread.start();
        //当调用get方法时，线程会阻塞在此，不调用会继续往下运行
        System.out.println("执行结果："+task.get());
        System.out.println("-----over-------");
    }
}
