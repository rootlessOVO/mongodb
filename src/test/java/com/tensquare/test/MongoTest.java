package com.tensquare.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoTest {
    public static void main(String[] args) {
        //连接mongo服务器
        MongoClient mongoClient=new MongoClient("106.75.22.244");
        //得到要操作的数据库
        MongoDatabase spitdb=mongoClient.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //封装查询条件只查询用户id为1013的
//        BasicDBObject bson=new BasicDBObject("userid","1013");
        //封装条件，查询访问量大于1000的 $gt
        BasicDBObject bson=new BasicDBObject("visits","1013");
        //得到集合中所有的文档
        FindIterable<Document> documents=spit.find();
        //遍历数据
        for (Document document :documents){
            System.out.println("内容："+document.getString("content"));
            System.out.println("用户id："+document.getString("userid"));
            System.out.println("访问量："+document.getDouble("visits"));
        }
   mongoClient.close();
    }
}
