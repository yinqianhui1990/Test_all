package com.springTest.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/10/16.
 */
@Component
public class InitInfo {
    @Autowired
    Card card;
    @PostConstruct
    public void init() {
        System.out.println("-------初始化--------");
        card.setId("1000");
        card.setName("yinzaige");
    }
}
