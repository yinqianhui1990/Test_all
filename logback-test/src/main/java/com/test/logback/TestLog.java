package com.test.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/8/28.
 */
public class TestLog {
    private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.debug("日志信息：123456");
        logger.info("logback 成功了");
        logger.error("logback 成功了");
    }
}
