package com.test.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ThinkPad on 2016/6/2.
 */
public class TestSlf4j {
    public static void main(String[] args) {

        PropertyConfigurator.configure("D:\\TestPro\\Test_all\\src\\main\\resources\\log4j.properties");

        Logger logger = Logger.getLogger(TestSlf4j.class);

        logger.info("yes");

        org.slf4j.Logger logger2 = LoggerFactory.getLogger(TestSlf4j.class);

        logger2.info("yes1");

        logger2.debug("hello2");

        logger2.warn("hello3");

        String a="hello";
        String b="world";
        logger2.info("test {} {}",a,b);


test(logger);

    }

    public static void test(Logger logger){
        try{
            int i=10/0;
        }catch (Exception e){
           /* e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            String str = sw.toString();
            logger.error("异常信息："+str);
           /// logger.error(e);
            try {
                sw.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }*/
            String str=getExceptionStr(e);
            logger.error(str);
        }
    }

    public static String getExceptionStr(Throwable e){
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw =  new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
    }

}
