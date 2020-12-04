package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerOrder90Controller {

    @Value("${service-url.nacos-user-service}")
    private String uri;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/cloud/nacos/rongduan/getOrder/{id}")
    public CommonResponse<Payment> getOrder(@PathVariable("id") Long id){
        log.info("uri：" + uri);

        CommonResponse<Payment> result = this.restTemplate.getForObject(uri + "/cloud/nacos/rongduan/getPayment/" + id, CommonResponse.class, id);

        return result;
    }




}
