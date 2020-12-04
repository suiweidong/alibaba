package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.enums.CommonCodeEnum;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class NacosJiangji9004Controller {

    @Value("${server.port}")
    private String ServerPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new Payment(2L, "bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L, new Payment(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping("/cloud/nacos/jiangji/getPayment/{id}")
    public CommonResponse<Payment> getPayment(@PathVariable("id") Long id){
        return new CommonResponse<>(CommonCodeEnum.SUCCESS.getCode(), CommonCodeEnum.SUCCESS.getName() + "- Port：" + ServerPort, hashMap.get(id));
    }
}
