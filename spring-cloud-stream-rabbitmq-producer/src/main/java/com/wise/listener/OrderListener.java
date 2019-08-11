package com.wise.listener;

import com.wise.config.Constants;
import com.wise.entity.Order;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 监听器
 */
@Component
public class OrderListener {

    @StreamListener(target = Constants.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    public void processCacheChannel(Order order) {
        System.out.println("cache: " + order);
    }

}