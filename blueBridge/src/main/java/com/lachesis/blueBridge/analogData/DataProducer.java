package com.lachesis.blueBridge.analogData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/9.
 */
public class DataProducer implements Runnable{
    private String macAddress;
    private long initialWeight;
    private String time;
    private BlockingQueue queue;//阻塞队列
    public DataProducer() {
    }

    public DataProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(long initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String produceData(){
        String res=null;
        try {
            initialWeight -= 1;
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
           // System.out.println(sdf.format(date));
            res = "lachesis002[0060]cl_event_ladrip_cur_weight@" + macAddress.toLowerCase() + "," + initialWeight + "," + sdf.format(date);
            if(initialWeight<=300){
                Random rand =new Random(25);
                initialWeight=rand.nextInt(5000);
            }
            System.out.println("线程" + Thread.currentThread().getName() + "produce:" + res);
            queue.put(res);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("生成数据异常");
        }
        return res;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
                produceData();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        DataProducer producer=new DataProducer();
        producer.setMacAddress("f0:23:b9:c0:00:66");
        producer.setInitialWeight(2500);
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.execute(producer);
    }
}
