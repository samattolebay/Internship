package com.example.paymentcoreapi.model;

import com.example.paymentcoreapi.repository.entities.ServiceEntity;

import java.util.List;

public class PaymentEntityResponse {
    private final String id;
    private final String client;
    private final List<ServiceEntity> services;
    private double totalAmount = 0;

    public PaymentEntityResponse(String id, String client, List<ServiceEntity> services) {
        this.id = id;
        this.client = client;
        this.services = services;
        services.forEach(service -> this.totalAmount += service.getAmount());
    }

    public String getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public List<ServiceEntity> getServices() {
        return services;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
