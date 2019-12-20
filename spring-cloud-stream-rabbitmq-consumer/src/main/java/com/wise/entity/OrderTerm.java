package com.wise.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单项实体
 */
@Data
public class OrderTerm implements Serializable {

    /**
     * 不支持驼峰
     */
    private String orderName;

    private Float amount;

    private String status;

}
