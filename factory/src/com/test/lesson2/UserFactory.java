package com.test.lesson2;

import com.test.lesson1.Impl.Oracle;
import com.test.lesson2.*;
import com.test.lesson2.Impl.MySqlUserImpl;
import com.test.lesson2.Impl.OracleUserImpl;

/**
 * Created by ThinkPad on 2017/3/21.
 * 简单工厂模式
 */
public class UserFactory {
    public static Iuser createUser(String name){
        if(name=="mysql"){
            return new MySqlUserImpl();
        }else if(name=="oracle"){
            return new OracleUserImpl();
        }else {
            return null;
        }
    }
}