package com.test.lesson4.factory.impl;

import com.test.lesson4.Iproduct;
import com.test.lesson4.Iuser;
import com.test.lesson4.factory.IFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class ManagerFactory implements IFactory{
    //private String dbName="MySql";
    //private String dbName="Oracle";
    private String dbName="SqlServer";
    @Override
    public Iuser createUser() {
        String className="com.test.lesson4.Impl."+dbName+"UserImpl";
        Iuser iuser=null;
        try {
            Class classType = Class.forName(className);
            iuser =(Iuser) classType.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return iuser;
    }

    @Override
    public Iproduct createProduct() {
        String className="com.test.lesson4.Impl."+dbName+"ProductImpl";
        Iproduct iproduct=null;
        try {
            Class classType = Class.forName(className);
            iproduct =(Iproduct) classType.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return iproduct;
    }
}
