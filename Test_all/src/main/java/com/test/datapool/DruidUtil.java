package com.test.datapool;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * Created by ThinkPad on 2016/11/8.
 */
public class DruidUtil {
    private static DataSource ds = null;
    public static long startTime=0;
    static {
        try{
            InputStream in = DruidUtil.class.getClassLoader()
                    .getResourceAsStream("druid.properties");
            Properties props = new Properties();
            props.load(in);
            ds = DruidDataSourceFactory.createDataSource(props);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection openConnection() throws SQLException {
       // System.out.println("getActiveCount===>>"+ ds.getActiveCount());
        return ds.getConnection();
    }
    /**
     * 数据库释放操作
     * @param conn
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

    public static void main(String[] args) throws Exception{
        for(int i=0;i<13000;i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Connection conn = openConnection();
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
