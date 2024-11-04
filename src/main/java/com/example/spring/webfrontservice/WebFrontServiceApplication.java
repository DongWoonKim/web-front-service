package com.example.spring.webfrontservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebFrontServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFrontServiceApplication.class, args);
    }

}
