package com.test.generator;

import com.test.dao.UserMapper;
import com.test.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(System.getProperty("user.dir"));
        System.out.println( "Hello World!" );
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
