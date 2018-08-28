package com.test.lesson2.client;

import com.test.lesson2.Iuser;
import com.test.lesson2.UserFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //使用接口的形式，如果要换oracle,就 new OracleUserImpl,但是如果oracle 类名改了就麻烦了，这里也要改，转到lesson2
        //现在我们就偏要换类名，因为Oracle这个表意不明，像个办法不改此处
        //Iuser user=new MySqlUserImpl();
        //Iuser user =new OracleUserImpl();//这行其实有原来的Oracle变成了OracleUserImpl()
        //现在用工厂创建,现在即使具体实现类怎么变，这里就不用改了，只需改工厂里面的实现类（适用于很多地方的调用）
        //但是如果要增加个sqlserver的实现类，那怎么办，工厂得新加判断，不符合开闭原则
        Iuser user= UserFactory.createUser("oracle");
        user.save();
    }
}
