package com.dataPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ThinkPad on 2017/3/20.
 */
@Component
public class TestPool {
    @Autowired
    DataSource dataSource;

    /**
     * 获得数据库连接
     *
     * @return Connection
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dataPool.xml");
        TestPool testPool = (TestPool) applicationContext.getBean("testPool");
        Connection connection = testPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        System.out.println(connection);
        try {
            preparedStatement = connection.prepareStatement("select count(*)  counts from inm_perbag_info");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("=======" + rs.getInt("counts"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            testPool.close(connection, preparedStatement, rs);
        }

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
