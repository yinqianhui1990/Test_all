package com.test.jedis.msgqueue;

import com.test.jedis.RedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/9/26.
 */
public class Consumer {
    //定义向队列读取字符串的方法
    public String  readMsg(String queueName){
        Jedis jedis=null;
        String value="";
        try {
            jedis = RedisUtil.getJedis();
            List<String> valueList=jedis.brpop(0, queueName);
            System.out.println("===="+valueList);
            if(valueList!=null) {
                value = valueList.get(1);
            }
            System.out.println("消费数据："+value);
            return value;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发生异常！"+e);
            return null;
        }finally {
            RedisUtil.returnResource(jedis);
        }
    }

    public static void main(String[] args) {
        Consumer consumer=new Consumer();
        int count=0;
        while (true){
            consumer.readMsg(Constants.receiveMsgQueue);
            System.out.println(++count+"读取次数");
        }
    }
}
