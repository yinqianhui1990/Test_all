package com.test.jdbc;



import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by ThinkPad on 2016/8/9.
 */
public final class DBUtils {

    private static String url ;
    private static String user ;
    private static String psw ;


    static {
        try {
            Properties prop = new Properties();

            InputStream in =DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(in);
            url=prop.getProperty("jdbc.url");
            user=prop.getProperty("jdbc.username");
            psw=prop.getProperty("jdbc.password");
            Class.forName(prop.getProperty("jdbc.driverClassName"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private DBUtils() {

    }

    /**
     * 获取数据库的连接
     * @return conn
     */
    public static Connection getConnection() {
         Connection conn=null;
        if(null == conn) {
            try {
                conn = DriverManager.getConnection(url, user, psw);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void closeResources(Connection conn,PreparedStatement pstmt,ResultSet rs) {
        if(null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                if(null != pstmt) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        if(null != conn) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }


    public  static  void  main(String []args)throws Exception {
        //没有使用线程池的情况会报错 Data source rejected establishment of connection,  message from server: "Too many connections
        //所以在有大并发的情况下需要使用线程池
        for (int i = 0; i < 3000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Connection conn = getConnection();
                        System.out.println("----------" + conn.getClass().getName());
                        PreparedStatement preparedStatement = conn.prepareStatement("select count(*)  counts from inm_perbag_info");
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            System.out.println("=======" + rs.getInt("counts"));
                        }
                        closeResources(conn, preparedStatement, rs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
