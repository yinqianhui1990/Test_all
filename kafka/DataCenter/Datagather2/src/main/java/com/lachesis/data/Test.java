package com.lachesis.data;

import com.lachesis.mybatis.DataInfoMapper;
import com.lachesis.pojo.DataInfo;
import com.lachesis.utils.UtilSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;

/**
 * Created by ThinkPad on 2016/8/22.
 */
public class Test {
    public static void main( String[] args )
    {
        System.out.println( "Hello Worlddsds!dfffffffff" );
        SqlSessionFactory sqlSessionFactory = UtilSession.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            DataInfo di=new DataInfo();
           // di.setSeqId(Long.parseLong("2"));
            di.setMacAddress("da:da:32:as:3e:99");
            di.setDataInfo("99");
            di.setDataType("HeartRate");
            di.setCreatTime(System.currentTimeMillis());
            DataInfoMapper dataInfoMapper=sqlSession.getMapper(DataInfoMapper.class);
            dataInfoMapper.insertSelective(di);
            DataInfo d2=dataInfoMapper.selectByPrimaryKey(Long.parseLong("1"));
            System.out.print("====="+d2.getDataInfo());
            sqlSession.commit();
        }catch ( Exception e){
            System.out.print("=====");
            e.printStackTrace();

        }finally {
            sqlSession.close();
        }

    }
}
