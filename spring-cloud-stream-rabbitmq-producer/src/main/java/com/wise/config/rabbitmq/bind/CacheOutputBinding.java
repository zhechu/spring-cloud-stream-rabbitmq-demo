package com.wise.config.rabbitmq.bind;

import com.wise.config.rabbitmq.RabbitMQConfig;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息绑定
 */
public interface CacheOutputBinding {

    @Output(RabbitMQConfig.STREAM_BINDING_CACHE_OUTPUT_CHANNEL)
    MessageChannel cacheOutputChannel();

}