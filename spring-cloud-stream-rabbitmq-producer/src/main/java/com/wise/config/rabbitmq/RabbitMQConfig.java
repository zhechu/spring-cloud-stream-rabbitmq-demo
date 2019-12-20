package com.wise.config.rabbitmq;

import com.wise.config.rabbitmq.bind.CacheInputBinding;
import com.wise.config.rabbitmq.bind.CacheOutputBinding;
import com.wise.config.rabbitmq.bind.OrderBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author lingyuwang
 * @date 2019/12/20 15:13
 **/
@Configuration
@EnableBinding({
        OrderBinding.class,
        CacheOutputBinding.class,
        CacheInputBinding.class
})
public class RabbitMQConfig {

    public final static String STREAM_BINDING_ORDER_OUTPUT_CHANNEL = "orderOutputChannel";

    public final static String STREAM_BINDING_CACHE_OUTPUT_CHANNEL = "cacheOutputChannel";

    public final static String STREAM_BINDING_CACHE_INPUT_CHANNEL = "cacheInputChannel";

}
