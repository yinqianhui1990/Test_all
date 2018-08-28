package com.test.jedis.msgqueue;

import com.test.jedis.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/9/26.
 */
public class Producer {

    //定义向队列发送字符串的方法
    public void  sendMsg(String queueName,String value){
        Jedis jedis=null;
        try {
            jedis = RedisUtil.getJedis();
            jedis.lpush(queueName, value);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发生异常！"+e);
        }finally {
           RedisUtil.returnResource(jedis);
        }
    }

    public static void main(String[] args) throws Exception{
        Producer producer=new Producer();
        for(int i=0;i<10000;i++) {
            producer.sendMsg(Constants.receiveMsgQueue,"number:"+i );
            System.out.println("生成数据："+i);
            Thread.sleep(10);
        }
    }
}
