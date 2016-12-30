package com.test.webservice;

import com.test.webservice.pojo.User;

/**
 * Created by ThinkPad on 2016/10/25.
 */
public class Client {

    public static void main(String[] args) {

        //首先右键run as 运行com.hsy.server.webServiceApp类，然后再运行这段客户端代码
       /* JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
        jwpfb.setServiceClass(HelloWorld.class);
        jwpfb.setAddress("http://localhost:8080/helloWorld");
        HelloWorld hw = (HelloWorld) jwpfb.create();
        User user = new User();
        user.setName("马克思");
        user.setDescription("怀念马克思");
        System.out.println(hw.sayHiToUser(user));*/
    }

    /*参数说明:

            -p 也就是package 对应Java中的包
    -d 输入目录,生成.java文件会在该目录,会自动添加-p参数配置的包路径
    -client 生成客户端测试web service的代码.
    -server 生成服务器启动web  service的代码.
    -impl 生成web service的实现代码.
    -ant  生成build.xml文件.
    -all 生成上面-client -server -impl -ant 对应的所有文件*/
    //http://blog.csdn.net/hu_shengyang/article/details/38384839

    //wsdl2java -p com.test.client -d f:\ -all http://localhost:8080/helloWorld?wsdl
}
