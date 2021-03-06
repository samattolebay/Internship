package com.example.mailcoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MailCoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailCoreApiApplication.class, args);
    }

}
