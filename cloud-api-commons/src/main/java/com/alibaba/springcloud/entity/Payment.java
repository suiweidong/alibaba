package com.alibaba.springcloud.entity;

import lombok.Data;

@Data
public class Payment {

    private Long id;

    private String uuid;

    public Payment(long id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }
}
