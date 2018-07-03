package com.sound.haolei.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(value = "com.sound.haolei.provider.dao")
public class DubboProviderDemo {
	//ceshi
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderDemo.class,args);
    }

}
