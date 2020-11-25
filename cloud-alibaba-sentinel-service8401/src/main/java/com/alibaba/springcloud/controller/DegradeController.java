package com.alibaba.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class DegradeController {

    /**
     * 慢调用比例测试用例
     * @return
     */
    @GetMapping(value = "/cloud/sentinel/degrade/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "=======testC 服务降级测试-慢调用比例";
    }

    /**
     * 异常比例 测试用例
     * @return
     */
    @GetMapping(value = "/cloud/sentinel/degrade/testD")
    public String testD(){

        int a = 10/0;

        return "=======testC 服务降级测试-异常比例";
    }

    /**
     * 异常数 测试用例
     * @return
     */
    @GetMapping(value = "/cloud/sentinel/degrade/testE")
    public String testE(){

        int a = 10/0;

        return "=======testC 服务降级测试-异常数";
    }

}
