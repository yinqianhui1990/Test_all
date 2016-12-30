package com.lachesis.mybatis;

import com.lachesis.flyover.client.FlyoverClientResult;
import com.lachesis.pojo.DataInfo;

import java.util.List;

public interface DataInfoMapper {
    int deleteByPrimaryKey(Long seqId);

    int insert(DataInfo record);

    int insertSelective(DataInfo record);

    DataInfo selectByPrimaryKey(Long seqId);

    int updateByPrimaryKeySelective(DataInfo record);

    int updateByPrimaryKey(DataInfo record);

    int insertFlyoverClientResultList(List flyoverClientResultList);
}