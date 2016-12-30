package com.lachesis.service.impl;

import com.lachesis.mybatis.DataInfoMapper;
import com.lachesis.pojo.DataInfo;
import com.lachesis.service.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2016/8/22.
 */
@Service(value = "dataMangerServiceImpl")
public class DataMangerServiceImpl implements DataManagerService {
    @Autowired
    private DataInfoMapper dataInfoMapper;

    public void saveDataInfo(DataInfo dataInfo) {
        dataInfoMapper.insertSelective(dataInfo);
    }

    public DataInfo getDataInfoById(Long id) {
       return dataInfoMapper.selectByPrimaryKey(id);
    }
    public int insertFlyoverClientResultList(List flyoverClientResultList){
        return dataInfoMapper.insertFlyoverClientResultList(flyoverClientResultList);
    }
}
