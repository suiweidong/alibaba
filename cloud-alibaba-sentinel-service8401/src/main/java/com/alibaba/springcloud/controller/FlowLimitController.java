package com.alibaba.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/cloud/sentinel/testA")
    public String testA() {
        log.info("===========:" +Thread.currentThread().getName() + "========testA");
        return "------testA";
    }

    @GetMapping("/cloud/sentinel/testB")
    public String testB() {
        return "------testB";
    }
}
