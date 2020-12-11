package com.alibaba.springcloud.fallback;

import com.alibaba.springcloud.cloudservice.SentinelFeignService;
import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements SentinelFeignService {

    @Override
    public CommonResponse<Payment> getPayment(Long id) {
        return new CommonResponse<>("112233","我是feign走降级熔断操作");
    }
}
