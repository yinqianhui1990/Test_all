package com.test.service.impl;

import com.test.dao.IAcountDao;
import com.test.model.Acount;
import com.test.service.IAcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2017/3/23.
 */
@Transactional
@Service
public class AcountServiceImpl implements IAcountService {
    @Autowired
    private IAcountDao acountDaoImpl;
    public void transerferAcount(Acount acount1, Acount acount2) {
        acountDaoImpl.updateAcount(acount1);
        acountDaoImpl.updateAcount(acount2);
    }
}
