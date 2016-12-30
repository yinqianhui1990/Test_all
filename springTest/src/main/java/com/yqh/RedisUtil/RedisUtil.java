package com.yqh.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by ThinkPad on 2016/11/14.
 */
@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取连接
     *
     * @return
     */
    @Lazy
    public Jedis getConnection() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return jedis;
    }

    /**
     * 关闭连接
     *
     * @param jedis
     */
    public void closeConnection(final Jedis jedis) {
        if (null != jedis) {
            try {
                jedisPool.returnResource(jedis);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
}
