package com.example.mailcoreapi.service;

import com.example.mailcoreapi.feign.ClientFeign;
import com.example.mailcoreapi.model.ClientResponse;
import com.example.mailcoreapi.model.MailEntityResponse;
import com.example.mailcoreapi.repository.MailEntity;
import com.example.mailcoreapi.repository.MailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailService {
    private final MailRepository mailRepository;
    private final ClientFeign clientFeign;

    public MailService(MailRepository mailRepository, ClientFeign clientFeign) {
        this.mailRepository = mailRepository;
        this.clientFeign = clientFeign;
    }

    public MailEntity saveMail(MailEntity mail) {
        return mailRepository.save(mail);
    }

    public List<MailEntityResponse> getAllMail() {
        List<MailEntity> mails = (List<MailEntity>) mailRepository.findAll();
        return mails.stream().map(this::getMailEntityResponse).collect(Collectors.toList());
    }

    private MailEntityResponse getMailEntityResponse(MailEntity mailEntity) {
        ClientResponse sender = clientFeign.getClient(mailEntity.getSenderId());
        String senderName = sender == null ? "Not Found" : sender.getFirstName();
        ClientResponse recipient = clientFeign.getClient(mailEntity.getRecipientId());
        String recipientName = recipient == null ? "Not Found" : recipient.getFirstName();
        String status = mailEntity.getStatus();
        String name = mailEntity.getName();
        return new MailEntityResponse(name, senderName, recipientName, status);
    }

    public void deleteAllMail() {
        mailRepository.deleteAll();
    }
}
