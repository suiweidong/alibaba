package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotKeyController {

    /**
     * 热点key 测试用例
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/cloud/sentinel/hotKey/testF")
    @SentinelResource(value = "hostKey_testF", blockHandler = "block_hostKey_testF")
    public String testF(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2){
        return "=====testF hostKey";
    }

    public String block_hostKey_testF(String p1, String p2, BlockException blockException){
        return "=====testF hostKey blockHandler /(ㄒoㄒ)/~~";
    }
}
