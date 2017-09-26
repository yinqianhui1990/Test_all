package com.test.all;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2017/6/21.
 */
public class ListTest {
    public static void main(String[] args) {
        List list1=new ArrayList();
        list1.add(1);
        List list2=new ArrayList();
        list2.addAll(list1);
        list1.add(2);
        list1.set(0,999);
        list1.clear();
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list2);
        System.out.println(list2.size());
    }
}
