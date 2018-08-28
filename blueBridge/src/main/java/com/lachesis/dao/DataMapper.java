package com.lachesis.dao;

import com.lachesis.model.DevData;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public interface DataMapper {
    public List<DevData> selectAllDevList();
}
