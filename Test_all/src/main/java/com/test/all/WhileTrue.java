package com.test.all;

import java.util.concurrent.Executors;

/**
 * Created by ThinkPad on 2017/8/11.
 */
public class WhileTrue {
    public boolean test9() {
        // return true;
        while (true) {
            try {
                System.out.println("----------------test---------------");
                dev();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("错误：" + e);
                e.printStackTrace();
            }
            int a = 1 / 0;
        }
    }

    public void dev() {
        int a = 10;
        a = a / 0;
    }

    public static void main(String[] args) {
/*        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                try {
                    while (true) {
                    System.out.println("------");
                    WhileTrue whileTrue = new WhileTrue();
                    whileTrue.test9();
                }
            } catch(Exception e){
                    System.out.println("发生异常，跳出循环！");
            }

        }
    });*/

        //下面才能保證循环不会因为异常而退出
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("------");
                        WhileTrue whileTrue = new WhileTrue();
                        whileTrue.test9();
                    } catch (Exception e) {
                        System.out.println("发生异常，跳出循环！");
                    }
                }
            }
        });

        System.out.println(123);
    }
}
