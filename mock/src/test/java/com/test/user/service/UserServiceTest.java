package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.dao.impl.UserDaoImpl;
import com.test.user.pojo.User;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/30.
 */
public class UserServiceTest extends TestCase {

    @Mock
    private UserDao userDao;
    private UserServiceImpl userService;

    public void setUp() throws Exception {
        userDao = Mockito.mock(UserDaoImpl.class);
        userService=new UserServiceImpl();
        userService.setUserDao(userDao);
    }

    public void tearDown() throws Exception {

    }

    public void testAddUser() throws Exception {
        User user =new User();
        user.setId("1");
        user.setName("yinqianhui");
        user.setPassWord("123456");
        when(userDao.insertUser(user)).thenReturn(1);
        boolean res=userService.addUser(user);
        assertTrue(res);
        when(userDao.insertUser(user)).thenReturn(0);
        boolean res2=userService.addUser(user);
        assertFalse(res2);
    }

    public void testGetUser()throws Exception{
        User user =new User();
        user.setId("1");
        user.setName("yinqianhui");
        user.setPassWord("123456");
        when(userDao.getUser("1")).thenReturn(user);
        assertNotNull(userService.getUser("1"));
        assertEquals(userService.getUser("1").getName(),"yinqianhui");
    }
}