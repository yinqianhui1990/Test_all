package com.test.webservice;

import com.test.webservice.impl.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by ThinkPad on 2016/10/25.
 */
public class AppTest {
    public static void main(String[] args) {
        System.out.println("web service start");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/helloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("web service started");
    }
}
