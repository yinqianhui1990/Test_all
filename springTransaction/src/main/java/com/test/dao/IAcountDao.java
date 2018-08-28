package com.test.dao;

import com.test.model.Acount;

/**
 * Created by ThinkPad on 2017/3/23.
 */
public interface IAcountDao {
    public void createTable();
    public void updateAcount(Acount acount);
    public void addAcount(Acount acount);

}
