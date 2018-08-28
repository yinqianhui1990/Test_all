package com.test.thread.run_callable;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/8/30.
 */
public class RunImpl implements Runnable{
    public void run() {
        System.out.println("正在执行run方法内容....");
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("执行run方法完成....");
    }

    public static void main(String[] args) {
        RunImpl runImpl=new RunImpl();
        Thread thread=new Thread(runImpl);
        thread.start();
    }
}
