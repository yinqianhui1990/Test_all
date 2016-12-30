package com.test.producer;

/**
 * Created by ThinkPad on 2016/5/9.
 */
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.Scanner;

/**
 * Created by outofmemory.cn on 14-8-26.
 *
 * activemq ������ʵ��
 */
public class ProducerApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerApp.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "test-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //��ʼ�����ӹ���
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //�������
        Connection conn = connectionFactory.createConnection();
        //��������
        conn.start();

        //����Session���˷�����һ��������ʾ�Ự�Ƿ���������ִ�У��ڶ��������趨�Ự��Ӧ��ģʽ
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //��������
        Destination dest = session.createQueue(SUBJECT);
        //createTopic������������Topic
        //session.createTopic("TOPIC");

        //ͨ��session���Դ�����Ϣ��������
        MessageProducer producer = session.createProducer(dest);
        for (int i=0;i<100;i++) {
            //��ʼ��һ��mq��Ϣ
            TextMessage message = session.createTextMessage("hello active mq ===" + i);
            //������Ϣ
            producer.send(message);
            LOGGER.debug("send message {}", i);
        }
        Scanner scanner=new Scanner(System.in);
        String res="";
        while(!(res=scanner.next()).equals("quit")){
            TextMessage message = session.createTextMessage("hello active mq ===" + res);
            //������Ϣ
            producer.send(message);
            LOGGER.debug("send message {}", res);
        }

        //�ر�mq����
        conn.close();
    }
}
