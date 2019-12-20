package com.wise.controller;

import com.wise.config.rabbitmq.bind.CacheOutputBinding;
import com.wise.config.rabbitmq.bind.OrderBinding;
import com.wise.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器
 */
@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderBinding orderBinding;

    @Autowired
    private CacheOutputBinding cacheBinding;

    @PostMapping("/publish")
    public String publishOrder(@RequestBody Order order) {
        // 订单发布
        orderBinding.orderOutputChannel().send(MessageBuilder.withPayload(order).build());

        // 订单缓存
        cacheBinding.cacheOutputChannel().send(MessageBuilder.withPayload(order).build());
        return "order_published";
    }

}
