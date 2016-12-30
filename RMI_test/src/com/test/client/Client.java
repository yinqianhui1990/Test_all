package com.test.client;

import com.test.service.Business;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ThinkPad on 2016/6/20.
 */
public class Client {

    public static  void  main(String [] agrs) throws  Exception{
        Registry registry= LocateRegistry.getRegistry("localhost",1099);
        String name ="BusinessDemo";
        Business business=(Business)registry.lookup(name);
        String res= business.echo("hello");
        System.out.println(res);
    }
}
