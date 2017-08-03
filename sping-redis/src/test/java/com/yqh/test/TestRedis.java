package com.yqh.test;


import com.yqh.redis.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class TestRedis{
    @Autowired
    RedisCache redisCache;
    @Test
    public void testRedis() throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("测试list");
        list.add("测试list2");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("test*","测试数据");
        map.put("测试数据","啥的");
        map.put("listTest",list);
        redisCache.putCache("testMap",map);

        Map<String,Object> mapResult = redisCache.getCache("testMap");
        System.out.print(mapResult.toString());
    }
}
