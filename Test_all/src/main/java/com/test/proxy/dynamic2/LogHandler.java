package com.test.proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/13.
 */
public class LogHandler implements InvocationHandler{
    Object tarGet;
    public Object newProxyInstance(Object tarGet){
        this.tarGet=tarGet;
        return Proxy.newProxyInstance(tarGet.getClass().getClassLoader(),tarGet.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行："+method.getName());
        Object res = method.invoke(tarGet, args);
        System.out.println("完成执行："+method.getName());
        return res;
    }
}
