package com.sound.haolei.consumer;


import com.sound.haolei.consumer.config.ResourceServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = "com.sound.haolei.consumer.controller")
@Import(ResourceServerConfig.class)
public class DubboConsumerDemo {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerDemo.class,args);
    }

}
