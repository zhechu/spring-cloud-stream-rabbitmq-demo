package com.wise.listener;

import com.wise.config.Constants;
import com.wise.entity.Order;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 监听器
 */
@Component
public class OrderListener {

    /**
     * 重试计数器
     */
    private final AtomicInteger count = new AtomicInteger();

    @StreamListener(target = Constants.STREAM_BINDING_ORDER_INPUT_CHANNEL)
    public void processOrderChannel(Order order) {
        System.out.println("publish: " + count.get());
        if (count.compareAndSet(3, 1)) {
            // 抛出此异常则将消息放入死信队列
            throw new AmqpRejectAndDontRequeueException("tried 3 times failed, send to dlq!");
        } else {
            count.incrementAndGet();
            // 抛出非 AmqpRejectAndDontRequeueException 异常则会不断重试
            throw new RuntimeException("Message consumer failed!");
        }
    }

    @StreamListener(target = Constants.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    public void processCacheChannel(Order order) {
        System.out.println("cache: " + order);
    }


}