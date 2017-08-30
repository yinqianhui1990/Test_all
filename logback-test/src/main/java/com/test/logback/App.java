package com.test.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        App app=new App();
        app.test();
    }

    public  void test(){
        logger.trace("trace:92993930");
        logger.debug("dubug信息：123456");
        logger.info("info: 成功了");
        logger.warn("WARN: test");
        logger.error("error: 错误");
    }
}
