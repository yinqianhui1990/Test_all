package com.test.lesson3.client;

import com.test.lesson3.Iuser;
import com.test.lesson3.factory.IFactory;
import com.test.lesson3.factory.impl.SqlServerFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //使用接口的形式，如果要换oracle,就 new OracleUserImpl,但是如果oracle 类名改了就麻烦了，这里也要改，转到lesson2
        //现在我们就偏要换类名，因为Oracle这个表意不明，像个办法不改此处
        //Iuser user=new MySqlUserImpl();
        //Iuser user =new OracleUserImpl();//这行其实有原来的Oracle变成了OracleUserImpl()
        //现在用工厂创建,现在即使具体实现类怎么变，这里都不用改了
        //但是如果要增加个sqlserver的实现类，那怎么办，工厂得新加判断，不符合开闭原则
       // Iuser user= UserFactory.createUser("oracle");
        //没关系，不是要加sqlserver,只要增加个sqlsever的工厂就好
        IFactory iFactory =new SqlServerFactory();
        Iuser user= iFactory.createUser();
        user.save();
        //假如还要增加新的表，例如product，新的操作怎么办呢，除了每次都要增加IProduct，以及三个实现类，还得
        //修改Ifactory,以及三个实现类工厂，代码会越来越多...要不要改进一下呢
    }
}
