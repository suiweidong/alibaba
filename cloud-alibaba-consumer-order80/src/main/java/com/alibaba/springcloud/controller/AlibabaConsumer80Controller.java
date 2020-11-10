package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.cloudservice.NacosFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AlibabaConsumer80Controller {

    @Resource
    private NacosFeignService nacosFeignService;

    @GetMapping(value = "/nacos/consumer/getPayment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return this.nacosFeignService.getPayment(id);
    }
}
