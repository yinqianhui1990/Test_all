package com.test.lesson3.client;

import com.test.lesson3.Iuser;
import com.test.lesson3.factory.IFactory;
import com.test.lesson3.factory.impl.SqlServerFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //ʹ�ýӿڵ���ʽ�����Ҫ��oracle,�� new OracleUserImpl,�������oracle �������˾��鷳�ˣ�����ҲҪ�ģ�ת��lesson2
        //�������Ǿ�ƫҪ����������ΪOracle������ⲻ��������취���Ĵ˴�
        //Iuser user=new MySqlUserImpl();
        //Iuser user =new OracleUserImpl();//������ʵ��ԭ����Oracle�����OracleUserImpl()
        //�����ù�������,���ڼ�ʹ����ʵ������ô�䣬���ﶼ���ø���
        //�������Ҫ���Ӹ�sqlserver��ʵ���࣬����ô�죬�������¼��жϣ������Ͽ���ԭ��
       // Iuser user= UserFactory.createUser("oracle");
        //û��ϵ������Ҫ��sqlserver,ֻҪ���Ӹ�sqlsever�Ĺ����ͺ�
        IFactory iFactory =new SqlServerFactory();
        Iuser user= iFactory.createUser();
        user.save();
        //���绹Ҫ�����µı�����product���µĲ�����ô���أ�����ÿ�ζ�Ҫ����IProduct���Լ�����ʵ���࣬����
        //�޸�Ifactory,�Լ�����ʵ���๤���������Խ��Խ��...Ҫ��Ҫ�Ľ�һ����
    }
}
