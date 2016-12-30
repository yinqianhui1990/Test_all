package com.test.webservice.impl;

import com.test.webservice.HelloWorld;
import com.test.webservice.pojo.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2016/10/25.
 */
@WebService(endpointInterface="com.test.webservice.HelloWorld",serviceName="HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public String sayHi(@WebParam(name = "text") String text) {
        return "Hello,"+text;
    }

    public String sayHiToUser(User user) {
        users.put(users.size()+1, user);
        if(user!=null) {
            return "Hello," + user.getName();
        }else{
            return "别瞎几把传空的给我！";
        }
    }

    public String[] SayHiToUserList(List<User> userList) {
        String[] result = new String[userList.size()];
        int i = 0;
        for(User u:userList){
            result[i] = "Hello " + u.getName();
            i++;
        }
        return result;
    }

}
