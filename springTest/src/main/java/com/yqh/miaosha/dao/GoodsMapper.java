package com.yqh.miaosha.dao;

import com.yqh.miaosha.model.Goods;

import java.util.HashMap;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer seqId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer seqId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int  updateGoodAmount(Goods goods);

    int deleteByGoodCode(String code);
}