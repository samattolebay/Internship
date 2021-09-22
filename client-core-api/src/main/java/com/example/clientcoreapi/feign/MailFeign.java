package com.example.clientcoreapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mail-core-api")
public interface MailFeign {
    @GetMapping("/healthcheck")
    String healthCheck();
}
