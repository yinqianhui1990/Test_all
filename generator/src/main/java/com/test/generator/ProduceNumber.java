package com.test.generator;

import com.test.dao.NumberMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import  com.test.model.Number;
/**
 * Created by ThinkPad on 2016/5/10.
 */
public class ProduceNumber {

    public static void main( String[] args )
    {
        SqlSessionFactory sqlSessionFactory =UtilSession.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            NumberMapper nMapper = sqlSession.getMapper(NumberMapper.class);
            for(int j=0;j<100000;j++) {
                com.test.model.Number number = new Number();
                List<Integer> list = new ArrayList();
                Random random = new Random();
                for (int i = 1; i <= 35; i++) {
                    list.add(i);
                }
                for (int i = 0; i < 7; i++) {
                    int index = random.nextInt(list.size());
                    if (i == 0) {
                        number.setNum1(list.get(index));
                    } else if (i == 1) {
                        number.setNum2(list.get(index));
                    } else if (i == 2) {
                        number.setNum3(list.get(index));
                    } else if (i == 3) {
                        number.setNum4(list.get(index));
                    } else if (i == 4) {
                        number.setNum5(list.get(index));
                    } else if (i == 5) {
                        number.setNum6(list.get(index));
                    } else if (i == 6) {
                        number.setNum7(list.get(index));
                    }
                    list.remove(index);
                }
                System.out.println(j);
                nMapper.insert(number);
                sqlSession.commit();
            }
        } finally {
            sqlSession.close();
        }
    }
}
