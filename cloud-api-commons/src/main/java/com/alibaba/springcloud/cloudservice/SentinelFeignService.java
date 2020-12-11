package com.alibaba.springcloud.cloudservice;

import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.fallback.PaymentFallbackService;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-alibaba-nacos-sentinel-service", fallback = PaymentFallbackService.class)
public interface SentinelFeignService {

    @GetMapping("/cloud/nacos/rongduan/getPayment/{id}")
    CommonResponse<Payment> getPayment(@PathVariable("id") Long id);
}
