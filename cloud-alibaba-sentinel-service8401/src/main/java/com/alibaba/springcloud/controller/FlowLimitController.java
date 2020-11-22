package com.alibaba.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/cloud/sentinel/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/cloud/sentinel/testB")
    public String testB() {
        return "------testB";
    }
}
