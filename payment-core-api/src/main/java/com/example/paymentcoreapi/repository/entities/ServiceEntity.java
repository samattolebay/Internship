package com.example.paymentcoreapi.repository.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class ServiceEntity {
//    @Field(type = FieldType.Keyword)
    private String type;

//    @Field(type = FieldType.Keyword)
    private double amount;

    public ServiceEntity() {
    }

    public ServiceEntity(String type, double amount) {
        this.type = type;
        this.amount = amount;
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
