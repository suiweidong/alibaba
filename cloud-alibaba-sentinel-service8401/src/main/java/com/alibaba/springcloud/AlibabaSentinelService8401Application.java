package com.alibaba.springcloud;

import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import com.alibaba.springcloud.utils.IPUntils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelService8401Application {

    public static void main(String[] args) {

        String ip = IPUntils.getOutIPV4();
        System.setProperty(TransportConfig.HEARTBEAT_CLIENT_IP, ip);

        SpringApplication.run(AlibabaSentinelService8401Application.class, args);
    }

}
