package com.example.paymentcoreapi.controller;

import com.example.paymentcoreapi.model.PaymentEntityResponse;
import com.example.paymentcoreapi.repository.entities.PaymentEntity;
import com.example.paymentcoreapi.service.PaymentService;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/all")
    public Page<PaymentEntityResponse> getAllPayment(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Page<PaymentEntityResponse> paymentEntities = paymentService.getAllPayment(page, limit);
        if (page > paymentEntities.getTotalPages()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such page!");
        }
        return paymentEntities;
    }

    @GetMapping("/{id}")
    public PaymentEntity getPayment(@PathVariable String id) {
        return paymentService.getPayment(id);
    }

    @DeleteMapping
    public void deleteAllPayment() {
        paymentService.deleteAllPayment();
    }
}