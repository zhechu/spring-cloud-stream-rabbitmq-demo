package com.wise.config.rabbitmq.bind;

import com.wise.config.rabbitmq.RabbitMQConfig;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 订单消息绑定
 */
public interface OrderBinding {

    @Input(RabbitMQConfig.STREAM_BINDING_ORDER_INPUT_CHANNEL)
    SubscribableChannel orderInputChannel();

}