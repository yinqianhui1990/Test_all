package com.test.lesson2.client;

import com.test.lesson2.Iuser;
import com.test.lesson2.UserFactory;

/**
 * Created by ThinkPad on 2017/3/21.
 */
public class Client2 {
    public static void main(String[] args) {
        //ʹ�ýӿڵ���ʽ�����Ҫ��oracle,�� new OracleUserImpl,�������oracle �������˾��鷳�ˣ�����ҲҪ�ģ�ת��lesson2
        //�������Ǿ�ƫҪ����������ΪOracle������ⲻ��������취���Ĵ˴�
        //Iuser user=new MySqlUserImpl();
        //Iuser user =new OracleUserImpl();//������ʵ��ԭ����Oracle�����OracleUserImpl()
        //�����ù�������,���ڼ�ʹ����ʵ������ô�䣬����Ͳ��ø��ˣ�ֻ��Ĺ��������ʵ���ࣨ�����ںܶ�ط��ĵ��ã�
        //�������Ҫ���Ӹ�sqlserver��ʵ���࣬����ô�죬�������¼��жϣ������Ͽ���ԭ��
        Iuser user= UserFactory.createUser("oracle");
        user.save();
    }
}
