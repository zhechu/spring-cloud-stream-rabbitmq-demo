package com.wise.config.rabbitmq.bind;

import com.wise.config.rabbitmq.RabbitMQConfig;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息绑定
 */
public interface CacheInputBinding {

    @Input(RabbitMQConfig.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    SubscribableChannel cacheInputChannel();

}