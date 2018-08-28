package com.test.lesson1.client;

import com.test.lesson1.Impl.MySqlUserImpl;
import com.test.lesson1.Impl.Oracle;
import com.test.lesson1.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //使用接口的形式，如果要换oracle,就 new OracleUserImpl,但是如果oracle 类名改了就麻烦了，这里也要改，转到lesson2
        //Iuser user=new MySqlUserImpl();
        Iuser user =new  Oracle();
        user.save();
    }
}
