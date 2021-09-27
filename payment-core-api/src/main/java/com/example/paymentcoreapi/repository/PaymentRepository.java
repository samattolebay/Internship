package com.example.paymentcoreapi.repository;

import com.example.paymentcoreapi.repository.entities.PaymentEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {
}
