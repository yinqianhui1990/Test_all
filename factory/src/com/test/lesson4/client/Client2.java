package com.test.lesson4.client;

import com.test.lesson4.Iproduct;
import com.test.lesson4.Iuser;
import com.test.lesson4.factory.IFactory;
import com.test.lesson4.factory.impl.ManagerFactory;


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
      /*  IFactory iFactory =new SqlServerFactory();
        Iuser user= iFactory.createUser();
        user.save();*/
        //���绹Ҫ�����µı�����product���µĲ�����ô���أ�����ÿ�ζ�Ҫ����IProduct���Լ�����ʵ���࣬����
        //�޸�Ifactory,�Լ�����ʵ���๤���������Խ��Խ��...Ҫ��Ҫ�Ľ�һ����

        //�Ľ���,ֻҪ��ManagerFactory��ʵ����صĻ�ȡʵ���Ľӿڣ��������õ����ݿ��Զ�ѡ����Ӧ����
        IFactory managerFactory=new ManagerFactory();
        Iuser iuser=managerFactory.createUser();
        iuser.save();
        iuser.selectUser();
        Iproduct iproduct=managerFactory.createProduct();  //�е���spring�����ע��
        iproduct.save();
        iproduct.selectUser();

    }
}
