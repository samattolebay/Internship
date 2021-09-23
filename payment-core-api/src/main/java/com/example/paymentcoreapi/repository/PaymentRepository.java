package com.example.paymentcoreapi.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {
}
