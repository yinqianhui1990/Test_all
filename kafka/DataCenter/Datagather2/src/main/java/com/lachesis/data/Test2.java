package com.lachesis.data;

import com.lachesis.flyover.client.FlyoverClientResult;
import com.lachesis.mybatis.DataInfoMapper;
import com.lachesis.pojo.DataInfo;
import com.lachesis.service.DataManagerService;
import com.lachesis.utils.Context;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2016/8/22.
 */
public class Test2 {
    public static void main( String[] args )
    {
        ApplicationContext app= Context.getApplicationContext();
        //User user=(User)app.getBean("user");
        DataManagerService dm= (DataManagerService)app.getBean("dataMangerServiceImpl");

       /* DataInfo di=new DataInfo();
        // di.setSeqId(Long.parseLong("2"));
        di.setMacAddress("da:da:32:as:3e:99");
        di.setDataInfo("100");
        di.setDataType("HeartRate");
        di.setCreatTime(System.currentTimeMillis());
        dm.saveDataInfo(di);*/
        List list=new ArrayList();
        for(int i=0;i<10;i++){
            FlyoverClientResult di=new FlyoverClientResult();
            // di.setSeqId(Long.parseLong("2"));
            di.setBtAddress("da:da:32:as:3e:99");
            di.setCoreData(80+i);
            di.setDataType("HeartRate");
            di.setDateTime(System.currentTimeMillis());
            list.add(di);
        }
        dm.insertFlyoverClientResultList(list);
        DataInfo d2=dm.getDataInfoById(Long.parseLong("1"));
        System.out.println("qqqq=====" + d2.getDataInfo());
    }
}
