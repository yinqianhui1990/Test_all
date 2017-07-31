package com.test.all;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ThinkPad on 2017/5/19.
 */
 public class SimpleListener implements ActionListener {
    /*
     * 利用该类来监听事件源产生的事件，利用响应机制
     */
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("按钮1"))
            System.out.println("按钮1 被点击");
    }
}


