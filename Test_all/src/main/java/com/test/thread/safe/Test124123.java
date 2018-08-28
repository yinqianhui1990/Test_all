package com.test.thread.safe;

/**
 * Created by ThinkPad on 2016/11/7.
 */
public class Test124123 implements Runnable{

    //线程独享该变量的副本，而并不影响其他线程获取该数据，即2个线程对该变量的操作互不影响，
    //适用于数据库连接管理，session管理等等
    static  ThreadLocal <Integer> localCount=new ThreadLocal<Integer>();
    public static  int count=0;


    public void run() {
        //synchronized (this) {
            for (int i = 0; i < 100; i++) {
               // System.out.println(Thread.currentThread().getName() + ":" + (count++));
                if(localCount.get()==null){
                    localCount.set(0);
                }else {
                    localCount.set(localCount.get()+1);
                }
                System.out.println(Thread.currentThread().getName() + ":"+localCount.get());
            }
       // }
    }

   /*  与上相同的效果
   public synchronized  void run() {

            for(int i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
            }

    }*/

    public static  void  main(String[] args){
     /*   Count count=new Count();
        Thread t1=new Thread(count,"test1");
        Thread t2=new Thread(count,"test2");
        t1.start();
        t2.start();*/
        Test124123 count=new Test124123();
        Test124123 count2=new Test124123();
        Thread t1=new Thread(count,"test1");
        Thread t2=new Thread(count2,"test2");
        t1.start();
        t2.start();
    }
}
