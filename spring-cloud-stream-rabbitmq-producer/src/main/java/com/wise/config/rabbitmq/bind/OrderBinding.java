package com.wise.config.rabbitmq.bind;

import com.wise.config.rabbitmq.RabbitMQConfig;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息绑定
 */
public interface OrderBinding {

    @Output(RabbitMQConfig.STREAM_BINDING_ORDER_OUTPUT_CHANNEL)
    MessageChannel orderOutputChannel();

}