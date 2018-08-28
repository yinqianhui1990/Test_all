package com.test.springTransaction;
import com.test.dao.IAcountDao;
import com.test.model.Acount;
import org.aspectj.util.LangUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ThinkPad on 2017/3/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {
    @Autowired
    IAcountDao acountDaoImpl;
   /* @Test
    public void create(){
        acountDaoImpl.createTable();
    }*/
   /* @Test
    public void addDATA(){
        Acount acount1=new Acount();
        acount1.setUserName("xiong2");
        acount1.setPassWord("123456");
        acount1.setBalance(1000);
        acountDaoImpl.addAcount(acount1);
    }*/
  /* @Test
   public void zhuanzhang(){
       //账户一给账户2转账100元
       float money=100;
       Acount acount1=new Acount();
       acount1.setId(1);
       acount1.setBalance(-1*money);
       Acount acount2=new Acount();
       acount2.setId(2);
       acount2.setBalance(money);
       //开始转账,未使用事物的状况，导致金额出现问题
       acountDaoImpl.updateAcount(acount1);
       acountDaoImpl.updateAcount(acount2);
   }*/

    @Test
    public void zhuanzhangOK(){
        //账户一给账户2转账100元
        float money=100;
        Acount acount1=new Acount();
        acount1.setId(1);
        acount1.setBalance(-1*money);
        Acount acount2=new Acount();
        acount2.setId(2);
        acount2.setBalance(money);
        //开始转账,使用事物的状况,还是会出现账户问题，没把这2个都放在一个事物里面
        acountDaoImpl.updateAcount(acount1);
        acountDaoImpl.updateAcount(acount2);
    }

}
