package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//https://blog.csdn.net/winter_chen001/article/details/77249029
@SpringBootApplication
@MapperScan("com.test.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class SbootmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootmybatisApplication.class, args);
	}
}
