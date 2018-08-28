package com.test.proxy.dynamic2;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/13.
 */
public class Test {
    public static void main(String[] args) {
        LogHandler proxy=new LogHandler();
        FlightManager flightManager=(FlightManager)proxy.newProxyInstance(new FlightManagerImpl());
        flightManager.buyFlight(1000,"北京");
       // flightManager.sendMessage();
    }
}
