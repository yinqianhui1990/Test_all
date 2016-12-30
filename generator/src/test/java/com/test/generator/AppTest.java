package com.test.generator;

import com.test.dao.UserMapper;
import com.test.model.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    private UserMapper userMapper;
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        SqlSessionFactory sqlSessionFactory =UtilSession.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByPrimaryKey(Long.parseLong("76"));
            System.out.println("name: " + user.getName() + "|age: "
                    + user.getCode());
        } finally {
            sqlSession.close();
        }


    }


}
