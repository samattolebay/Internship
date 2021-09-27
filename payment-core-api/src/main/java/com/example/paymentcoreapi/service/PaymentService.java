package com.example.paymentcoreapi.service;

import com.example.paymentcoreapi.feign.ClientFeign;
import com.example.paymentcoreapi.model.ClientResponse;
import com.example.paymentcoreapi.model.PaymentEntityResponse;
import com.example.paymentcoreapi.repository.CustomPageImpl;
import com.example.paymentcoreapi.repository.entities.PaymentEntity;
import com.example.paymentcoreapi.repository.PaymentRepository;
import com.example.paymentcoreapi.repository.entities.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ClientFeign clientFeign;

    public PaymentService(PaymentRepository paymentRepository, ClientFeign clientFeign) {
        this.paymentRepository = paymentRepository;
        this.clientFeign = clientFeign;
    }

    public PaymentEntity savePayment(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    public Page<PaymentEntityResponse> getAllPayment(int page, int limit) {
        Page<PaymentEntity> paymentEntities = paymentRepository.findAll(PageRequest.of(page, limit));
        List<PaymentEntityResponse> payments = new ArrayList<>();
        paymentEntities.forEach(paymentEntity -> payments.add(getPaymentEntityResponse(paymentEntity)));
        long total = paymentEntities.getTotalElements();
        return new CustomPageImpl<>(payments, PageRequest.of(page, limit), total);
    }

    private PaymentEntityResponse getPaymentEntityResponse(PaymentEntity paymentEntity) {
        String id = paymentEntity.getId();
        ClientResponse sender = clientFeign.getClient(paymentEntity.getClientId());
        String clientName = sender == null ? "Not Found" : sender.getFirstName();
        List<ServiceEntity> services = paymentEntity.getServices();
        return new PaymentEntityResponse(id, clientName, services);
    }

    public PaymentEntity getPayment(String id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such payment"));
    }

    public void deleteAllPayment() {
        paymentRepository.deleteAll();
    }
}
