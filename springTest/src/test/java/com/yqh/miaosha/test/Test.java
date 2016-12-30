package com.yqh.miaosha.test;

import com.springTest.autoscan.Student;
import com.yqh.miaosha.model.Goods;
import com.yqh.miaosha.service.GoodsService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Test {
    CountDownLatch latch=new CountDownLatch(100);
    @Autowired
    GoodsService goodServiceImpl;

    @Before
    public void inser() {
        Goods goods=new Goods();
        goods.setCode("g1");
        goods.setName("bear");
        goods.setAmount(1000);
        goodServiceImpl.insert(goods);

    }
    int totalBuys=0;
    int totalUser=0;
    @org.junit.Test
    public void buy(){

        for(int i=0;i<1000;i++) {
            new Thread(new Runnable() {
                public void run() {
                    try{
                        latch.await();
                    }catch (Exception e){

                    }
                    Goods goods = new Goods();
                    goods.setCode("g1");
                    goods.setAmount(7);
                    boolean res = goodServiceImpl.updateGoodAmount(goods);
                    if (res) {
                        System.out.println("购买成功！==" + goods.getAmount());
                        totalBuys+=goods.getAmount();
                        totalUser++;
                    } else {
                        System.out.println("购买失败！");
                    }
                }
            }).start();
            latch.countDown();
        }
        try{
        Thread.sleep(3000L);
        }catch (Exception e){

        }
        System.out.println("卖出货物："+totalBuys);
        System.out.println("购买人数："+totalUser);
    }
    @After
    public void del() {
        goodServiceImpl.deleteByGoodCode("g1");

    }



}
