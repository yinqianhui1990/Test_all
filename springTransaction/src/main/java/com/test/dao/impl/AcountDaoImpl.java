package com.test.dao.impl;

import com.test.dao.IAcountDao;
import com.test.model.Acount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2017/3/23.
 */
@Transactional
@Repository
public class AcountDaoImpl implements IAcountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addAcount(Acount acount) {
        jdbcTemplate.update("insert into ACOUNTS(user_name,password,balance) values(?,?,?)",
                new Object[]{acount.getUserName(),acount.getPassWord(),acount.getBalance()});
    }

    public void createTable() {
        jdbcTemplate.execute("create table ACOUNTS (id integer,user_name varchar(40),password varchar(40),balance FLOAT )");
    }

    public void updateAcount(Acount acount) {
        jdbcTemplate.update("update ACOUNTS set balance=balance+? where id=?",
                new Object[]{acount.getBalance(),acount.getId()});
        //异常后，加了事物会回滚（Transactional），否则不会
        if(acount.getId()==1) {
            throw new NullPointerException();
        }
    }
}
