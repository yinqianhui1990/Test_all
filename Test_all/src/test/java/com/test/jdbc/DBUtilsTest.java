package com.test.jdbc;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/15.
 */
public class DBUtilsTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        assertNotNull(new DBUtils());

    }

/** 
* 
* Method: getTest() 
* 
*/ 

public void testGetTest() throws Exception { 
//TODO: Test goes here... 
} 

    public void testCloseResources() throws Exception {
        System.out.println("关闭");
        Connection connection=DBUtils.getConnection();
        assertNotNull(connection);
        PreparedStatement preparedStatement=connection.prepareStatement("");
        assertNotNull(preparedStatement);
        DBUtils.closeResources(connection,preparedStatement,null);

    }
}