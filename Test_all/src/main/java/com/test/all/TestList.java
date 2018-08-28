package com.test.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/1/15.
 */
public class TestList {
    public static void main(String[] args) {
        List list=new ArrayList();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        for(int j=0;j<5;j++){
            list.remove(j+1);
            System.out.println("size:"+list.size());
        }
    }
}
