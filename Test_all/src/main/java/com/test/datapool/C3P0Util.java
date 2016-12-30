package com.test.datapool;

/**
 * Created by ThinkPad on 2016/11/7.
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewProxyConnection;


/**
 * 数据库工具类
 * @author liang
 *
 */
public class C3P0Util {
    static ComboPooledDataSource cpds=null;
    static{
        //这里有个优点，写好配置文件，想换数据库，简单
        //cpds = new ComboPooledDataSource("oracle");//这是oracle数据库
        cpds = new ComboPooledDataSource("mysql");//这是mysql数据库
    }
    /**
     * 获得数据库连接
     * @return   Connection
     */
    public static Connection getConnection(){
        try {
            System.out.println("getInitialPoolSize===>>"+ cpds.getInitialPoolSize());
            System.out.println("getNumIdleConnections===>>"+ cpds.getNumIdleConnections());
            System.out.println("getNumBusyConnections===>>"+ cpds.getNumBusyConnections());
            System.out.println("getNumConnections===>>"+ cpds.getNumConnections());
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据库关闭操作
     * @param conn
     * @param st
     * @param pst
     * @param rs
     */
    public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 测试DBUtil类
     * @param args
     */
    public static void main(String[] args) throws Exception{
    for(int i=0;i<13000;i++) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Connection conn = getConnection();
                    System.out.println("----------" + conn.getClass().getName()+"=="+conn);
                    PreparedStatement preparedStatement = conn.prepareStatement("select count(*)  counts from inm_perbag_info");
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        System.out.println("======="+rs.getInt("counts"));
                    }
                    close(conn, preparedStatement, rs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    }




}
