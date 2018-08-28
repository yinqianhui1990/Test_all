package com.lachesis.blueBridge;

import com.lachesis.blueBridge.Server.DataServer;
import com.lachesis.blueBridge.Server.SendDataThread;
import com.lachesis.blueBridge.analogData.DataProducer;
import com.lachesis.dao.DataMapper;
import com.lachesis.model.DevData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "服务开始咯" );
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10000);

        try {
            //1.启动socket服务
            System.out.println("启动socketserver");
            new Thread(new DataServer()).start();
            //-------------------------------
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                //2.生成数据
                DataMapper dataMapper=session.getMapper(DataMapper.class);
                List<DevData> list2=dataMapper.selectAllDevList();
                System.out.println("启动数据生成任务");
                ExecutorService executorService = Executors.newFixedThreadPool(50);
                Random rand =new Random(25);
                for(DevData devData:list2) {
                    DataProducer producer = new DataProducer(queue);
                    producer.setMacAddress(devData.getMacAddress());
                    producer.setInitialWeight(rand.nextInt(5000));
                    executorService.execute(producer);
                }
            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.发送数据
        System.out.println("启动发送任务");
        new Thread( new SendDataThread(queue)).start();
    }
}
