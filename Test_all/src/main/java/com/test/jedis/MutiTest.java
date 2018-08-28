package com.test.jedis;

import redis.clients.jedis.Jedis;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/8/24.
 */
public class MutiTest implements Runnable {

    Jedis jedis;

    public MutiTest(Jedis jedis) {
        this.jedis = jedis;
    }

    public void run() {
        try {
            System.out.println(jedis);
            jedis.set("name", "123");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " name======" + jedis.get("name"));
        } catch (Exception e) {
            System.out.println("错误：" + e);
        } finally {
            RedisUtil.returnResource(jedis);
        }
    }

    public static void main(String[] args) {
        //为每隔线程获取一个jedis，这是没问题的
   /*     for(int i=0;i<10;i++) {
            Jedis jedis1 = RedisUtil.getJedis();
            MutiTest mutiTest1 = new MutiTest(jedis1);
            Thread t1 = new Thread(mutiTest1);
            t1.start();
            Jedis jedis2 = RedisUtil.getJedis();
            MutiTest mutiTest2 = new MutiTest(jedis2);
            Thread t2 = new Thread(mutiTest2);
            t2.start();
        }*/
        System.out.println("----------------猥琐的分割线--------------------");
        //所有线程共用一个jedis，会出现错误
        Jedis jedis1 = RedisUtil.getJedis();
        for (int i = 0; i < 3; i++) {
            MutiTest mutiTest1 = new MutiTest(jedis1);
            Thread t1 = new Thread(mutiTest1);
            t1.start();
            MutiTest mutiTest2 = new MutiTest(jedis1);
            Thread t2 = new Thread(mutiTest2);
            t2.start();
            MutiTest mutiTest3 = new MutiTest(jedis1);
            Thread t3 = new Thread(mutiTest3);
            t3.start();
        }
    }
}
