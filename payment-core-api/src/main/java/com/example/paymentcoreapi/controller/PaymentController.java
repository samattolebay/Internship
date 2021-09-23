package com.example.paymentcoreapi.controller;

import com.example.paymentcoreapi.model.PaymentEntityResponse;
import com.example.paymentcoreapi.repository.PaymentEntity;
import com.example.paymentcoreapi.service.PaymentService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    private final Environment env;
    private final PaymentService paymentService;


    public PaymentController(Environment env, PaymentService paymentService) {
        this.env = env;
        this.paymentService = paymentService;
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Payment API is working: " + env.getProperty("local.server.port");
    }

    @PostMapping("/save")
    public PaymentEntity savePayment(@RequestBody PaymentEntity payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/all/{page}")
    public List<PaymentEntityResponse> getAllPayment(@PathVariable int page) {
        return paymentService.getAllPayment(page);
    }

    @GetMapping("/{id}")
    public PaymentEntity getPayment(@PathVariable String id) {
        return paymentService.getPayment(id);
    }
}