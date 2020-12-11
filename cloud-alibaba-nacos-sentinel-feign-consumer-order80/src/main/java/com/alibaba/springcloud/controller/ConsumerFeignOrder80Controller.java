package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.cloudservice.SentinelFeignService;
import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerFeignOrder80Controller {

    @Resource
    private SentinelFeignService sentinelFeignService;

    @GetMapping("/cloud/comsumer/sentinel/feign/getOrder/{id}")
    public CommonResponse<Payment> getOrder(@PathVariable("id") Long id){
        return this.sentinelFeignService.getPayment(id);
    }
}
