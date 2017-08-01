package com.test.service;

import com.test.service.DemoService;

/**
 * Created by ThinkPad on 2016/4/22.
 */
public class DemoServiceImpl implements DemoService{

    public String sayHello(String name) {
        System.out.println("有人调用我了");
        return "服务器说："+name+",你好！！！！";
    }
}
