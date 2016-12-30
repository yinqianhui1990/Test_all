package com.test.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ThinkPad on 2016/6/20.
 */
public interface Business extends Remote {
    public String echo(String message) throws RemoteException;


}
