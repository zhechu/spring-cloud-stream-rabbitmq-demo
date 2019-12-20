package com.wise.listener;

import com.wise.config.RabbitMQConfig;
import com.wise.entity.Order;
import com.wise.entity.OrderTerm;
import com.wise.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 监听器
 */
@Component
@Slf4j
public class OrderListener {

    /**
     * 重试计数器
     */
    private final AtomicInteger count = new AtomicInteger();

    @StreamListener(target = RabbitMQConfig.STREAM_BINDING_ORDER_INPUT_CHANNEL)
    public void processOrderChannel(Order order) {
        log.info("order:{}", order);
        log.info("publish: {}", count.get());

//        if (count.compareAndSet(3, 1)) {
//            // 抛出此异常则将消息放入死信队列
//            throw new AmqpRejectAndDontRequeueException("tried 3 times failed, send to dlq!");
//        } else {
//            count.incrementAndGet();
//            // 抛出非 AmqpRejectAndDontRequeueException 异常则会不断重试
//            throw new RuntimeException("Message consumer failed!");
//        }
    }

    @StreamListener(target = RabbitMQConfig.STREAM_BINDING_CACHE_INPUT_CHANNEL)
    public void processCacheChannel(Order order) {
        log.info("cache: {}", order);
    }

    @StreamListener(target = RabbitMQConfig.STREAM_BINDING_STRING_INPUT_CHANNEL)
    public void processStringChannel(String string) {
        log.info("string: {}", string);

        OrderTerm orderTerm = JacksonUtil.readValue(string, OrderTerm.class);
        log.info("string orderTerm: {}", orderTerm);
    }

}