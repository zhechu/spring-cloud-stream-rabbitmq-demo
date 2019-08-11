package com.wise.bind;

import com.wise.config.Constants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 订单消息绑定
 */
public interface OrderBinding {

    @Input(Constants.STREAM_BINDING_ORDER_INPUT_CHANNEL)
    SubscribableChannel orderInputChannel();

}