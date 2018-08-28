package com.test.mongo;

import com.mongodb.*;

import java.util.List;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/8/22.
 */
public class Test1 {
    //http://limingnihao.iteye.com/blog/1940438
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //数据库列表
            List<String> listDb=mongoClient.getDatabaseNames();
            for(String db:listDb){
                System.out.println("数据库："+db);
            }

            //链接bearshop数据库
            DB bearShopDb=mongoClient.getDB("bearshop");
            mongoClient.setWriteConcern(WriteConcern.JOURNALED);
            System.out.println("==="+bearShopDb.getCollectionNames());
            for(String coll:bearShopDb.getCollectionNames()){
               System.out.println("bearshop中的集合（表）："+coll);
           }

            // 5.获取摸个集合对象
            DBCollection coll = bearShopDb.getCollection("user");

            //新增
            BasicDBObject basicDBObject=new BasicDBObject("id","yyy").append("name","yyy").append("password","123456");
            WriteResult result0 = coll.insert(basicDBObject);
            System.out.println("insert-result: " + result0);
            // 2.1查询 - one
            DBObject myDoc = coll.findOne();
            System.out.println("第一个文档："+myDoc);

            // 2.2 查询 - 数量
            System.out.println("集合数量："+coll.getCount());

            // 2.3查询 - 全部
            DBCursor cursor = coll.find();
            while (cursor.hasNext()) {
                System.out.println("全部--------" + cursor.next());
            }

            // 2.4查询 - 过滤 - 等于
            BasicDBObject query = new BasicDBObject("id", "123");
            cursor = coll.find(query);
            while (cursor.hasNext()) {
                System.out.println("查询结果-------" + cursor.next());
            }
            //修改
            DBObject search = coll.findOne(new BasicDBObject("id", "123"));
            BasicDBObject object = new BasicDBObject().append("$set", new BasicDBObject("password", "111111"));
            WriteResult result = coll.update(search, object, true, true);
            System.out.println("update-result: " + result);

            //删除
            //DBObject search2 = coll.findOne(new BasicDBObject("id", "yyy"));
            DBObject search2 = new BasicDBObject("id", "yyy");
            WriteResult result2 = coll.remove(search2);
            System.out.println("remove-result: " + result2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
