package com.mutil.datadource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by ThinkPad on 2016/8/16.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // TODO Auto-generated method stub
        return DynamicDataSourceHolder.getDataSouce();
    }

}



