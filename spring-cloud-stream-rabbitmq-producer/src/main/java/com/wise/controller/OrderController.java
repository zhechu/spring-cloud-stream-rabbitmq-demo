package com.wise.controller;

import com.wise.config.RabbitMQConfig;
import com.wise.entity.Order;
import com.wise.entity.OrderTerm;
import com.wise.util.JacksonUtil;
import org.springframework.beans.BeanUtils;
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
    private RabbitMQConfig.OutputBinding outputBinding;

    @PostMapping("/publish")
    public String publishOrder(@RequestBody Order order) {
        // 订单发布
        outputBinding.orderOutputChannel().send(MessageBuilder.withPayload(order).build());

        // 订单缓存
        outputBinding.cacheOutputChannel().send(MessageBuilder.withPayload(order).build());

        // 字符串
        OrderTerm orderTerm = new OrderTerm();
        BeanUtils.copyProperties(order, orderTerm);
        outputBinding.stringOutputChannel().send(MessageBuilder.withPayload(JacksonUtil.writeValueAsString(orderTerm)).build());
        return "order_published";
    }

}
