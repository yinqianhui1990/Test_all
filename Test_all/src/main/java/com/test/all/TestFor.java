package com.test.all;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2017/7/31.
 */
public class TestFor {
    public static void main(String[] args) {
        ScheduledExecutorService executorCheckBag = Executors
                .newSingleThreadScheduledExecutor();
        executorCheckBag.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                // 每隔30秒校正一次输液袋信息
                try {
                    for(int i=0;i<10;i++){
                        try {
                            if(i==5){
                                //throw new Exception();
                                // int a=1/0;
                              /*  String b="123";
                               int a= b.lastIndexOf("*");
                                b.substring(a-5,a);*/
                                String a=null;
                                System.out.println(a.lastIndexOf("*"));

                            }
                            System.out.println("number:" + i);
                        }catch (Exception e){
                            System.out.println("xunhuan==="+e.getMessage());
                            System.out.println("msg:"+e);
                            //尽量少用或者别用e.getMessage();
                            int a=1/0;
                        }
                    }
               }catch (Exception e){
                    System.out.println("renwu==="+e.getMessage());
                    //int a=1/0;
                    System.out.println(123);
                }
            }
        }, 5, 5, TimeUnit.SECONDS);



    }
}
