package com.alibaba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class AlibabaConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerOrder80Application.class, args);
    }

}
