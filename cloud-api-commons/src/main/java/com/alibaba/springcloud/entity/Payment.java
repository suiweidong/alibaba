package com.alibaba.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String uuid;

    public Payment(long id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }
}
