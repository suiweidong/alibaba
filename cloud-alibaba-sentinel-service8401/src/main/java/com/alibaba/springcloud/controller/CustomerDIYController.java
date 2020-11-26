package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.springcloud.enums.CommonCodeEnum;
import com.alibaba.springcloud.myhandler.CustomerBlockHandler;
import com.alibaba.springcloud.utils.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDIYController {

    @GetMapping("/cloud/sentinel/customerDiyHandler/cbh")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResponse<String> customerBlockHandler() {
        return new CommonResponse<>(CommonCodeEnum.SUCCESS.getCode(), "客户自定义限流处理逻辑-测试用例");
    }
}
