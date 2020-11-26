package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.springcloud.enums.CommonCodeEnum;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelResourceController {

    /**
     * 通过资源路径配置-进行服务降级
     * @return
     */
    @GetMapping("/cloud/sentinel/sentinelResource/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResourceDefaultFallBack")
    public CommonResponse<String> byResource(){
        return new CommonResponse<>(CommonCodeEnum.SUCCESS.getCode(), "通过资源路径配置");
    }
    public CommonResponse<String> byResourceDefaultFallBack(BlockException blockException){
        return new CommonResponse<>(CommonCodeEnum.FAIL.getCode(), "通过资源路径配置-进行服务降级");
    }

    /**
     * 通过url路径配置
     * @return
     */
    @GetMapping("/cloud/sentinel/sentinelResource/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResponse<String> byUrl(){
        return new CommonResponse<>(CommonCodeEnum.SUCCESS.getCode(), "通过url路径配置");
    }

}
