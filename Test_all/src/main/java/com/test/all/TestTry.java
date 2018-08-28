package com.test.all;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/9/6.
 */
public class TestTry {
   static List list=null;

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                System.out.println(123123);
            }
        }.start();

        try {
            System.out.println(1);
            list =new ArrayList();
            list.add(1);
            list.add(2);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("a");
                        List list2 =new ArrayList();
                        list2.addAll(list);
                        list.clear();
                        Thread.sleep(3000);
                        System.out.println("b");
                        System.out.println(list2.size());
                        System.out.println(list2.toString());
                    }catch (Exception e){

                    }finally {
                        System.out.println("c");
                    }
                }
            }).start();
            //list.clear();
        }catch (Exception e){
            System.out.println(2);
        }finally {
            System.out.println(3);
           //list.clear();
        }
    }
}
