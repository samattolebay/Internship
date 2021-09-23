package com.example.paymentcoreapi.model;

public class PaymentEntityResponse {
    private String id;
    private String client;
    private String type;
    private double amount;

    public PaymentEntityResponse(String id, String client, String type, double amount) {
        this.id = id;
        this.client = client;
        this.type = type;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
