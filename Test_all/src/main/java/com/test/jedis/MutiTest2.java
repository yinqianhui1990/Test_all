package com.test.jedis;

import redis.clients.jedis.Jedis;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/8/24.
 */
public class MutiTest2 implements Runnable {



    public MutiTest2() {

    }

    public void run() {
        Jedis jedis=RedisUtil.getJedis();
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
        for (int i = 0; i < 100; i++) {
            MutiTest2 mutiTest1 = new MutiTest2();
            Thread t1 = new Thread(mutiTest1);
            t1.start();
            MutiTest2 mutiTest2 = new MutiTest2();
            Thread t2 = new Thread(mutiTest2);
            t2.start();
            MutiTest2 mutiTest3 = new MutiTest2();
            Thread t3 = new Thread(mutiTest3);
            t3.start();
        }
    }
}
