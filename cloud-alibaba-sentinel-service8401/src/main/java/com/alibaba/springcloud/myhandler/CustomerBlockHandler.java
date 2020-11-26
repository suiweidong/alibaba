package com.alibaba.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.springcloud.enums.CommonCodeEnum;
import com.alibaba.springcloud.utils.CommonResponse;

public class CustomerBlockHandler {

    public static CommonResponse<String> handlerException(BlockException blockException){
        return new CommonResponse<>(CommonCodeEnum.FAIL.getCode(), "客户自定义限流处理方案，%>_<%");
    }

}
