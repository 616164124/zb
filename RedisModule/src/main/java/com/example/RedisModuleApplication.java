package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisModuleApplication {
    private static final Logger log = LoggerFactory.getLogger(RedisModuleApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(RedisModuleApplication.class, args);
        log.info("完成。。。。");
    }

}
