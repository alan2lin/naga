package com.alan2lin.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.alan2lin.bbs", "com.alibaba.cola"})
@MapperScan("com.alan2lin.bbs.customer")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
