package com.alibaba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelRongduanFeignOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelRongduanFeignOrder80Application.class, args);
    }

}
