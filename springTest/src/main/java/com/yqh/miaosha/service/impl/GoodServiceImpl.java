package com.yqh.miaosha.service.impl;

import com.yqh.miaosha.dao.GoodsMapper;
import com.yqh.miaosha.model.Goods;
import com.yqh.miaosha.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by ThinkPad on 2016/11/11.
 */
@Service(value = "goodServiceImpl")
public class GoodServiceImpl implements GoodsService{
    public Long getGoodAmount(String code) {
        return null;
    }

    @Autowired
    private GoodsMapper goodsMapper;
    public boolean insert(Goods record) {
        return goodsMapper.insert(record)==1;
    }

    public boolean deleteByGoodCode(String code) {
        return goodsMapper.deleteByGoodCode(code)==1;
    }

    public boolean updateGoodAmount(Goods record) {
        return goodsMapper.updateGoodAmount(record)==1;
    }
}
