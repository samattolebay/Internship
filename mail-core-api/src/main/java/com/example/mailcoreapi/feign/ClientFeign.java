package com.example.mailcoreapi.feign;

import com.example.mailcoreapi.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-core-api")
public interface ClientFeign {
    @GetMapping("/healthcheck")
    String healthCheck();

    @GetMapping("/{id}")
    ClientResponse getClient(@PathVariable String id);
}
