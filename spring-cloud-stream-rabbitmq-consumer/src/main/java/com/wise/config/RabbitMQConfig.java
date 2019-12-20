package com.wise.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lingyuwang
 * @date 2019/12/20 15:13
 **/
@Configuration
@EnableBinding({
        RabbitMQConfig.InputBinding.class
})
public class RabbitMQConfig {

    public final static String STREAM_BINDING_ORDER_INPUT_CHANNEL = "orderInputChannel";

    public final static String STREAM_BINDING_CACHE_INPUT_CHANNEL = "cacheInputChannel";

    public final static String STREAM_BINDING_STRING_INPUT_CHANNEL = "stringInputChannel";

    /**
     * 监听消息绑定
     */
    interface InputBinding {

        @Input(RabbitMQConfig.STREAM_BINDING_STRING_INPUT_CHANNEL)
        SubscribableChannel stringInputChannel();

        @Input(RabbitMQConfig.STREAM_BINDING_CACHE_INPUT_CHANNEL)
        SubscribableChannel cacheInputChannel();

        @Input(RabbitMQConfig.STREAM_BINDING_ORDER_INPUT_CHANNEL)
        SubscribableChannel orderInputChannel();

    }

}
