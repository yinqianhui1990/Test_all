package com.yqh.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by ThinkPad on 2016/11/11.
 */
public interface RedisDataSource {
    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
