package com.yqh.redis;

import com.yqh.redis.impl.RedisClientTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TestRedis {
    @Autowired
    RedisClientTemplate redisClientTemplate;
    @org.junit.Test
    public void buy(){
        redisClientTemplate.set("test","test");
        System.out.println("name:"+redisClientTemplate.get("name"));
        System.out.println("amount:"+redisClientTemplate.get("g1"));
    }
}
