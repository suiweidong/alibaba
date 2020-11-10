package com.alibaba.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AlibabaProvicer9002Controller {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/provider/getPayment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "alibaba服务提供者，id "+ id +"，端口：" + serverPort + " uuid：" + UUID.randomUUID().toString();
    }
}
