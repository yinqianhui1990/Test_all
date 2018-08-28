package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ThinkPad on 2017/3/16.
 */
@SpringBootApplication
public class AppStart {
    //如果放在与action包的根目录下，就会自动配置所有的action
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}
