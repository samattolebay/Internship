package com.example.paymentcoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentCoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentCoreApiApplication.class, args);
    }

}
