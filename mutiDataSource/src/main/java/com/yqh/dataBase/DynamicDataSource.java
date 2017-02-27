package com.yqh.dataBase;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by ThinkPad on 2017/2/23.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(){

    }
    @Override
    protected Object determineCurrentLookupKey() {
        // 在进行DAO操作前，通过上下文环境变量，获得数据源的类型
        return DataSourceHandle.getDataSourceType();
    }

}
