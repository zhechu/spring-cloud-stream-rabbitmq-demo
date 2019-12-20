package com.wise.config.rabbitmq;

import com.wise.config.rabbitmq.bind.CacheInputBinding;
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
        CacheInputBinding.class
})
public class RabbitMQConfig {

    public final static String STREAM_BINDING_ORDER_INPUT_CHANNEL = "orderInputChannel";

    public final static String STREAM_BINDING_CACHE_INPUT_CHANNEL = "cacheInputChannel";

}
