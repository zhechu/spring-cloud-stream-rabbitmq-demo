package com.wise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * 访问：http://127.0.0.1:7084/orders2/publish POST { "order_name": "order 1", "amount": 5000, "status": "new" }
 */
@SpringBootApplication
public class ProducerTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerTwoApplication.class, args);
    }

}
