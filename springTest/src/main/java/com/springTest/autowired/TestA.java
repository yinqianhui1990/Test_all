package com.springTest.autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2017/6/9.
 */
@Service
@Scope("prototype")   //多例模式
public class TestA {
    int data=0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void print(){
        System.out.println("estt=="+data);
    }
}
