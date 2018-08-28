package com.test.dao;

import com.test.model.Number;

public interface NumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Number record);

    int insertSelective(Number record);

    Number selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Number record);

    int updateByPrimaryKey(Number record);

    Number selectByNum_1(Integer num_1,Integer num_2);

}