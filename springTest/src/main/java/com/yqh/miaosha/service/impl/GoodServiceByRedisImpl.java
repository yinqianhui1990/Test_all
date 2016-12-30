package com.yqh.miaosha.service.impl;

import com.yqh.miaosha.dao.GoodsMapper;
import com.yqh.miaosha.model.Goods;
import com.yqh.miaosha.service.GoodsService;
import com.yqh.redis.impl.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@Service(value = "goodServiceByRedisImpl")
public class GoodServiceByRedisImpl implements GoodsService{
    @Autowired
    private RedisClientTemplate redisClientTemplate;
    public boolean insert(Goods record) {
        String  res = redisClientTemplate.set(record.getCode(),record.getAmount().toString());
        System.out.println("result===================:"+res);
        return "OK".endsWith(res);
    }

    public boolean deleteByGoodCode(String code) {

        return true;
    }

    public boolean updateGoodAmount(Goods record) {
        Long res=redisClientTemplate.decr(record.getCode(), record.getAmount());

        if(res>0){
            System.out.println("当前剩余货物数量===================:"+res);
           return true;
        }else{
            res=redisClientTemplate.incr(record.getCode(), record.getAmount());
            System.out.println("当前剩余货物数量===================:"+res);
            return false;
        }

    }
    public Long getGoodAmount(String code) {
        return Long.parseLong(redisClientTemplate.get(code));
    }
}
