package com.yqh.miaosha.service.impl;

import com.yqh.RedisUtil.RedisUtil;
import com.yqh.miaosha.model.Goods;
import com.yqh.miaosha.service.GoodsService;
import com.yqh.redis.impl.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@Service(value = "goodServiceByRedisPositiveLockImpl")
public class GoodServiceByRedisPositiveLockImpl implements GoodsService{
    @Autowired
    private RedisUtil redisUtil;
    public boolean insert(Goods record) {
        Jedis jedis=redisUtil.getConnection();
        String  res =jedis .set(record.getCode(),record.getAmount().toString());
        System.out.println("result===================:"+res);
        redisUtil.closeConnection(jedis);
        return "OK".endsWith(res);
    }

    public boolean deleteByGoodCode(String code) {

        return true;
    }

    public boolean updateGoodAmount(Goods record) {
        Jedis jedis=redisUtil.getConnection();


        while("OK".equals(jedis.watch(record.getCode()))&&jedis.isConnected()){
            Long res=Long.parseLong(jedis.get(record.getCode()));
            List<Object> result=null;
            if(res>0&&(res=res-record.getAmount())>=0)
            {
            Transaction tx = jedis.multi();
            tx.set(record.getCode(),res.toString() );
                result = tx.exec();
                if (result == null || result.isEmpty()) {
                    jedis.unwatch();
                    System.out.println(Thread.currentThread().getId()+"执行失败===================:"+result);
                    redisUtil.closeConnection(jedis);
                } else {
                    System.out.println("当前剩余货物数量===================:"+res);
                    redisUtil.closeConnection(jedis);
                    return true;
                }
            }else{
                redisUtil.closeConnection(jedis);
                return false;
            }


        }
        return false;
    }
    public Long getGoodAmount(String code) {
        Jedis jedis=redisUtil.getConnection();
        Long res=Long.parseLong(jedis.get(code));
        redisUtil.closeConnection(jedis);
        return res;
    }
}
