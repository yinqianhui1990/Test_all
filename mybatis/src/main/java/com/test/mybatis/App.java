package com.test.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.test.model.User;

import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Hello World!");
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            try {
                //方案一直接写对应方法名 我改了一下2018-07-26
                List<User> list =  session.selectList("com.test.mapper.UserMapper.selectAllUser");
                System.out.println(list);

                //方案二 此方法更常用，更安全
                UserMapper userMapper=session.getMapper(UserMapper.class);
                List<User> list2=userMapper.selectAllUser();
                System.out.println("="+list2);

                //分页插件测试
                Page page =PageHelper.startPage(1, 10, true);
                List<User> list3=userMapper.selectAllUser();
                PageInfo<User> pageInfo =new PageInfo<>(list3);
                System.out.println("total:"+page.getTotal());
                System.out.println("分页结果="+list3.size());
                System.out.println(pageInfo.getTotal());
                System.out.println(pageInfo.getPages());

            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
