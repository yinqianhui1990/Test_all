package com.test.lesson1.client;

import com.test.lesson1.Impl.MySqlUserImpl;
import com.test.lesson1.Impl.Oracle;
import com.test.lesson1.Iuser;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //ʹ�ýӿڵ���ʽ�����Ҫ��oracle,�� new OracleUserImpl,�������oracle �������˾��鷳�ˣ�����ҲҪ�ģ�ת��lesson2
        //Iuser user=new MySqlUserImpl();
        Iuser user =new  Oracle();
        user.save();
    }
}
