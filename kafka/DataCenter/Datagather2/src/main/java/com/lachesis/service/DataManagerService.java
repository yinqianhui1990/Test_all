package com.lachesis.service;

import com.lachesis.pojo.DataInfo;

import java.util.List;

/**
 * Created by ThinkPad on 2016/8/22.
 */
public interface DataManagerService {
    public void  saveDataInfo(DataInfo dataInfo);
    public  DataInfo getDataInfoById(Long id);
    public int  insertFlyoverClientResultList(List flyoverClientResultList);
}
