package com.consumerservice01;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ConsumerService02Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerService02Application.class, args);
    }

}
