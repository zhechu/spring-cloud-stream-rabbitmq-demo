package com.wise.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单实体
 */
@Data
@ToString
public class Order implements Serializable {

    /**
     * 不支持驼峰
     */
    @JsonProperty("order_name")
    private String orderName;

    private Float amount;

    private String status;

}
