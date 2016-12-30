package com.test.service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ThinkPad on 2016/6/20.
 */
public class Server {
    public static  void  main(String [] agrs) throws  Exception{
        int port =9090;
        String name ="BusinessDemo";
        Business business=new BusinessImpl();
        UnicastRemoteObject.exportObject(business,port);
        Registry registry= LocateRegistry.createRegistry(1099);
        registry.bind(name,business);


    }
}
