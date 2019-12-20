package com.wise.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lingyuwang
 * @date 2019/12/20 15:13
 **/
@Configuration
@EnableBinding({
        RabbitMQConfig.InputBinding.class,
        RabbitMQConfig.OutputBinding.class
})
public class RabbitMQConfig {

    public final static String STREAM_BINDING_ORDER_OUTPUT_CHANNEL = "orderOutputChannel";

    public final static String STREAM_BINDING_CACHE_OUTPUT_CHANNEL = "cacheOutputChannel";

    public final static String STREAM_BINDING_STRING_OUTPUT_CHANNEL = "stringOutputChannel";

    public final static String STREAM_BINDING_CACHE_INPUT_CHANNEL = "cacheInputChannel";

    /**
     * 监听消息绑定
     */
    interface InputBinding {

        @Input(RabbitMQConfig.STREAM_BINDING_CACHE_INPUT_CHANNEL)
        SubscribableChannel cacheInputChannel();

    }

    /**
     * 发送消息绑定（需要开放）
     */
    public interface OutputBinding {

        @Output(RabbitMQConfig.STREAM_BINDING_ORDER_OUTPUT_CHANNEL)
        MessageChannel orderOutputChannel();

        @Output(RabbitMQConfig.STREAM_BINDING_CACHE_OUTPUT_CHANNEL)
        MessageChannel cacheOutputChannel();

        @Output(RabbitMQConfig.STREAM_BINDING_STRING_OUTPUT_CHANNEL)
        MessageChannel stringOutputChannel();

    }

}
