package com.wise.bind;

import com.wise.config.Constants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息绑定
 */
public interface CacheInputBinding {

    @Input(Constants.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    SubscribableChannel cacheInputChannel();

}