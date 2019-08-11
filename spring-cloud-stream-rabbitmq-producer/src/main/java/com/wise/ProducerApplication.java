package com.wise;

import com.wise.bind.CacheInputBinding;
import com.wise.bind.CacheOutputBinding;
import com.wise.bind.OrderBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 启动类
 * 访问：http://127.0.0.1:8081/orders/publish POST { "order_name": "order 1", "amount": 5000, "status": "new" }
 */
@SpringBootApplication
@EnableBinding({
        OrderBinding.class,
        CacheOutputBinding.class,
        CacheInputBinding.class
})
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
