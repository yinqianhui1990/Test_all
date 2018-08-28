package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-mock.xml" })
public class UserServiceImplTest {
    @InjectMocks
    @Autowired
    private UserService userServiceImpl;   //被测试对象
    @Mock
    private UserDao userDao;


    /*
    * service 被标记了 @InjectMocks , 在 myBefore方法中 执行 MockitoAnnotations.initMocks(this); 的时候，
    * 会将标记了 @Mock 或 @Spy 的属性注入到 service 中。如果是 @Mock, 那就是通常的方式，service里面
    * 的provider完全被Mock实例替换，所有的调用都是针对Mock生成类的。
    * 如果是 @Autowired 加 @Spy , 那么对于定制了返回值的会调用 Mock实例，否则会调用真实注入的属性，
    * 但是这里有一个限制，如果是代理类会报错，比如Spring 的AOP代理。  www.2cto.com
     对于AOP的代理类，如果想一部分用Mock，一部分用真实的实例，感觉目前是有些困难，暂时想到的办法就是
     写两个测试类，一个注入真实属性，一个注入mock属性。
     */
    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() throws Exception {
        //模拟创建一个List对象
        List mock = Mockito.mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
        User user=new User();
        user.setId("1");
        user.setName("yinqianhui");
        user.setPassWord("123456");
        when(userDao.insertUser(user)).thenReturn(1);
        boolean res = userServiceImpl.addUser(user);
        assertTrue(res);
    }

    @Test
    public void testGetUser() throws Exception {
        User user=new User();
        user.setId("1");
        user.setName("yinqianhui");
        user.setPassWord("123456");
        when(userDao.getUser("1")).thenReturn(user);
        assertNotNull(user);
        assertEquals("yinqianhui",userServiceImpl.getUser("1").getName());
    }
}