package com.test.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThinkPad on 2016/12/19.
 */
public class Ticket {

    public static  void queryTicket(){
        try {
            System.out.println("开始搜索.....");
            String dates[] = {"2017-01-12", "2017-01-13"
                    , "2017-01-14", "2017-01-15", "2017-01-16", "2017-01-17", "2017-01-18", "2017-01-19", "2017-01-20", "2017-01-21", "2017-01-22", "2017-01-23", "2017-01-24", "2017-01-25", "2017-01-26"};
            String stations[] = {"SZQ", "GZQ"};

            for (int k = 0; k < stations.length; k++) {
                for (int i = 0; i < dates.length; i++) {
                    String date = dates[i];
                    try {
                        String jstr = HttpUtils.httpsGet("https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date=" +
                                date + "&leftTicketDTO.from_station=" + stations[k] + "&leftTicketDTO.to_station=KAQ&purpose_codes=ADULT");
                        // System.out.println(jstr);
                        JSONObject jsonObject = JSON.parseObject(jstr);
                        if (jsonObject != null) {
                            //System.out.println(jsonObject.get("data"));
                            if (jsonObject.get("data") != null) {
                                JSONArray jsonArray = JSON.parseArray(jsonObject.get("data").toString());
                                for (int j = 0; j < jsonArray.size(); j++) {

                                    JSONObject queryLeftNewDTO = JSON.parseObject(jsonArray.get(j).toString());
                                    //  System.out.println(queryLeftNewDTO.get("queryLeftNewDTO"));
                                    JSONObject NewDTO = JSON.parseObject(queryLeftNewDTO.get("queryLeftNewDTO").toString());
                                    if (NewDTO.get("ze_num").equals("有") || NewDTO.get("yw_num").equals("有") || NewDTO.get("rw_num").equals("有") ||
                                            NewDTO.get("rz_num").equals("有") || NewDTO.get("yz_num").equals("有")|| NewDTO.get("wz_num").equals("有")) {
                                        String temp = "";
                                        temp = NewDTO.get("wz_num").equals("有") ? "无座" : temp;
                                        temp = NewDTO.get("yz_num").equals("有") ? "硬座" : temp;
                                        temp = NewDTO.get("rz_num").equals("有") ? "软座" : temp;
                                        temp = NewDTO.get("rw_num").equals("有") ? "软卧" : temp;
                                        temp = NewDTO.get("ze_num").equals("有") ? "二等座" : temp;
                                        temp = NewDTO.get("yw_num").equals("有") ? "硬卧" : temp;
                                        System.out.println(date + "--------------有-" + temp + "-票---------------" + NewDTO.get("station_train_code") + "-" + NewDTO.get("from_station_name") +
                                                "-" + NewDTO.get("start_time") + "-" + NewDTO.get("arrive_time") + "-历时：" + NewDTO.get("lishi"));
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        // e.printStackTrace();
                        System.out.println("解析错误");
                    }
                }
            }
            System.out.println("结束本轮搜索.....");
        }catch (Exception e){
            System.out.println("=="+e.getMessage());
        }
    }

    public static void main(String[] args) {
        //
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                queryTicket();
            }
        }, 5, 6, TimeUnit.SECONDS);
    }


}
