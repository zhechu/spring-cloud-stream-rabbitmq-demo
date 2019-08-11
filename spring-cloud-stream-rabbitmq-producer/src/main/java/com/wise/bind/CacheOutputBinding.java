package com.wise.bind;

import com.wise.config.Constants;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息绑定
 */
public interface CacheOutputBinding {

    @Output(Constants.STREAM_BINDING_CACHE_OUTPUT_CHANNEL)
    MessageChannel cacheOutputChannel();

}