package com.test.all;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ThinkPad on 2016/12/8.
 */
public class test22 {
    public static void main(String[] args) {
        String a="123,124";
        List<String> test= Arrays.asList(a.split(","));
        System.out.println(test);
    }
}
