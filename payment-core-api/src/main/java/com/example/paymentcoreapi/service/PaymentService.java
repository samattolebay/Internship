package com.example.paymentcoreapi.service;

import com.example.paymentcoreapi.feign.ClientFeign;
import com.example.paymentcoreapi.model.ClientResponse;
import com.example.paymentcoreapi.model.PaymentEntityResponse;
import com.example.paymentcoreapi.repository.PaymentEntity;
import com.example.paymentcoreapi.repository.PaymentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    public static final int size = 10;
    private final ClientFeign clientFeign;

    public PaymentService(PaymentRepository paymentRepository, ClientFeign clientFeign) {
        this.paymentRepository = paymentRepository;
        this.clientFeign = clientFeign;
    }

    public PaymentEntity savePayment(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    public List<PaymentEntityResponse> getAllPayment(int page) {
        List<PaymentEntity> paymentEntities = paymentRepository.findAll(PageRequest.of(page, size)).getContent();
        return paymentEntities.stream().map(this::getPaymentEntityResponse).collect(Collectors.toList());
    }

    private PaymentEntityResponse getPaymentEntityResponse(PaymentEntity paymentEntity) {
        String id = paymentEntity.getId();
        ClientResponse sender = clientFeign.getClient(paymentEntity.getClientId());
        String clientName = sender == null ? "Not Found" : sender.getFirstName();
        String type = paymentEntity.getType();
        double amount = paymentEntity.getAmount();
        return new PaymentEntityResponse(id, clientName, type, amount);
    }

    public PaymentEntity getPayment(String id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such payment"));
    }
}
