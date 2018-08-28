package com.test.monitor;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/19.
 * 这个用来监控客户端的运行情况
 */
public class ZkMonitor {
    public static void main(String[] args) throws  Exception{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString("localhost:2181")
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .build();
        client.start();
        TreeCache cache = new TreeCache(client, "/client");
        cache.getListenable().addListener(new TreeCacheListener() {
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println(treeCacheEvent.getData().getPath()+":"+treeCacheEvent.getType());
            }
        });
        cache.start();
        Thread.sleep(1000*1000);
    }
}
