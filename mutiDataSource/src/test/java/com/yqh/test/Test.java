package com.yqh.test;

import com.yqh.dataBase.DataSourceConst;
import com.yqh.dataBase.DataSourceHandle;
import com.yqh.model.User;
import com.yqh.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Test
{
    @Autowired
    UserService userService;
    @org.junit.Test
    public void testApp(){
        for(int i=0;i<100;i++) {
            DataSourceHandle.setDataSourceType(DataSourceConst.LocalDataSource);
            User user = userService.getUser(4);
            System.out.println("user=" + user.getName());
            DataSourceHandle.setDataSourceType(DataSourceConst.RemoteDataSource);
            User user2 = userService.getUser(4);
            System.out.println("user=" + user2.getName());
        }
    }
}
