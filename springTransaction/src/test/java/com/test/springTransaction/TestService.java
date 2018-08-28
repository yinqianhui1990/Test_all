package com.test.springTransaction;
import com.test.dao.IAcountDao;
import com.test.model.Acount;
import com.test.service.IAcountService;
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
public class TestService {
    @Autowired
   private IAcountService acountServiceImpl;
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
        //开始转账,使用事物的状况,把这2个都放在一个事物里面
        acountServiceImpl.transerferAcount(acount1,acount2);
    }

}
