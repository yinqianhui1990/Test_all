package com.test.generator;

import com.test.dao.NumberMapper;
import com.test.dao.UserMapper;
import com.test.model.*;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by ThinkPad on 2017/3/13.
 */
public class NumberTest extends TestCase{

    public void test(){
        System.out.println("测试开始");
        SqlSessionFactory sqlSessionFactory =UtilSession.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            NumberMapper numberMapper = sqlSession.getMapper(NumberMapper.class);
            // User user = userMapper.selectByPrimaryKey(Long.parseLong("4"));
            com.test.model.Number number =numberMapper.selectByNum_1(1,2);
            System.out.println("num: " + number.toString());
        } finally {
            sqlSession.close();
        }
    }

}
