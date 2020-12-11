package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.springcloud.entity.Payment;
import com.alibaba.springcloud.enums.CommonCodeEnum;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 使用ribbon方式
 */
@RestController
public class ConsumerRibbonOrder80Controller {

    @Value("${service-url.nacos-user-service}")
    private String uri;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/cloud/nacos/rongduan/getOrder/{id}")
//    @SentinelResource(value = "getOrderFallback") // 没有配置
//    @SentinelResource(value = "getOrderFallback", fallback = "handlerFallback")  // fallback只负责编码异常
//    @SentinelResource(value = "getOrderFallback", blockHandler = "blockHandler")  // blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "getOrderFallback", fallback = "handlerFallback", blockHandler = "blockHandler",
        exceptionsToIgnore = {IllegalArgumentException.class})  // blockHandler只负责sentinel控制台配置违规
    public CommonResponse<Payment> getOrder(@PathVariable("id") Long id){
        CommonResponse result = this.restTemplate.getForObject(uri + "/cloud/nacos/rongduan/getPayment/" + id, CommonResponse.class, id);

        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常");
        } else if (result.getRecord() == null){
            throw new NullPointerException("NullPointerException, 空指针异常");
        }

        return result;
    }

    /**
     * fallback只负责编码异常
     * @param id
     * @param e
     * @return
     */
    public CommonResponse<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e){
        Payment payment = new Payment(id, "aaaaaaaaa");
        return new CommonResponse<>(CommonCodeEnum.FALL_BACK.getCode(), "兜底异常handlerFallback, Exception内容：" + e.getMessage(), payment);
    }

    /**
     * blockHandler只负责sentinel控制台配置违规
     * @param id
     * @param blockException
     * @return
     */
    public CommonResponse<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException){
        Payment payment = new Payment(id, "bbbbbbbbb");
        return new CommonResponse<>(CommonCodeEnum.BLOCK_HANDLER.getCode(), "blockHandler-sentinel限流，无此流水：blockException " + blockException.getMessage(), payment);
    }


}
