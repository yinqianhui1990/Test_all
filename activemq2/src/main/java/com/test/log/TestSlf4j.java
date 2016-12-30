package com.test.log;

import org.slf4j.LoggerFactory;

/**
 * Created by ThinkPad on 2016/6/2.
 */
public class TestSlf4j {
    public static void main(String[] args) {

      /*  PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(TestSlf4j.class);

        logger.info("yes");*/

        org.slf4j.Logger logger2 = LoggerFactory.getLogger(TestSlf4j.class);

        logger2.info("yes1");

        logger2.debug("hello2");

        logger2.warn("hello3");

    }
}
