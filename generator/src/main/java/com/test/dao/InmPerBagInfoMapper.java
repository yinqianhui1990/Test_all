package com.test.dao;

import com.test.model.InmPerBagInfo;

public interface InmPerBagInfoMapper {
    int deleteByPrimaryKey(Long seqId);

    int insert(InmPerBagInfo record);

    int insertSelective(InmPerBagInfo record);

    InmPerBagInfo selectByPrimaryKey(Long seqId);

    int updateByPrimaryKeySelective(InmPerBagInfo record);

    int updateByPrimaryKey(InmPerBagInfo record);
}