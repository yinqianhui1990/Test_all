package com.test.client.sw;

import com.test.client.sw.clients.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class App extends JFrame{
    //1. 定义组件
    JButton sendButton;
    JTextArea content;
    JTextArea result;
    Client client;
    String showStr="";
    public void CreateJFrame(){
        JFrame jf = new JFrame("客户发送端"); // 实例化一个JFrame对象
        Container container = jf.getContentPane(); // 获取一个容器
        JLabel labelc=new JLabel("发送内容:");
        content = new JTextArea();
        content.setSize(500,200);
        sendButton = new JButton("发送");
        sendButton.setSize(100,50);
        JLabel labelr=new JLabel("返回结果:");
        result = new JTextArea();
        result.setSize(500,100);
        container.add(labelc);
        container.add(content);
        container.add(sendButton);
        container.add(labelr);
        container.add(result);
        container.setLayout(new GridLayout(5,1));

        //
        client=new Client();
        client.connect("localhost",9998);
        sendButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
             String contStr=content.getText();
                try{
                    client.sendMessage(contStr);
                }catch ( Exception x){
                    x.printStackTrace();
                    client.connect("localhost",9998);
                }

            }
        });
        jf.setVisible(true); // 使窗体可视
        jf.setSize(800, 600); // 设置窗体大小
        // 设置窗体关闭方式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        String res = client.readMessage();
                      /*  if (res.contains(client.getHeader())) {
                            showStr = "";
                        }*/
                        System.out.println(res);
                       // showStr += res;
                       // if (res.contains(client.getTail())) {
                            result.setText(res);
                     //   }
                    }catch (Exception e){
                        e.printStackTrace();
                        client.connect("localhost",9998);
                    }
                }
            }
        }).start();
    }
    public static void main( String[] args )
    {
          new App().CreateJFrame();
    }
}
