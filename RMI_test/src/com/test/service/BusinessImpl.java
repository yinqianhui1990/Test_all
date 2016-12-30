package com.test.service;

import java.rmi.RemoteException;

/**
 * Created by ThinkPad on 2016/6/20.
 */
public class BusinessImpl implements Business {
    @Override
    public String echo(String message) throws RemoteException {
        System.out.println("client:"+message);
        return "server response:"+message;
    }
}
