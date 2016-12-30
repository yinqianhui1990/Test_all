package com.test.webservice;

import com.test.webservice.pojo.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by ThinkPad on 2016/10/25.
 */
@WebService
public interface HelloWorld {
    String sayHi(@WebParam(name="text")String text);
    String sayHiToUser(User user);
    String[] SayHiToUserList(List<User> userList);
}
