package com.wise.listener;

import com.wise.config.rabbitmq.RabbitMQConfig;
import com.wise.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 监听器
 */
@Component
@Slf4j
public class OrderListener {

    @StreamListener(target = RabbitMQConfig.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    public void processCacheChannel(Order order) {
        log.info("cache: {}", order);
    }

}