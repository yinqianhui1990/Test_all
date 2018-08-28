package com.test.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/19.
 */
public class Client2 {
    public static void main(String[] args) throws Exception{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString("localhost:2181")
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .build();
        client.start();
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/client/222", "client2".getBytes());
        System.out.println("====2:"+new String(client.getData().forPath("/client/222")));
        Thread.sleep(1000*60);
    }
}
