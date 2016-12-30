package com.yqh.miaosha.service;

import com.yqh.miaosha.model.Goods;

import java.util.HashMap;

/**
 * Created by ThinkPad on 2016/11/11.
 */
public interface GoodsService {
    boolean insert(Goods record);
    boolean  updateGoodAmount(Goods record);
    boolean deleteByGoodCode(String code);
    Long getGoodAmount (String code);


}
