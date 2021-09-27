package com.example.mailcoreapi.controller;

import com.example.mailcoreapi.model.MailEntityResponse;
import com.example.mailcoreapi.repository.MailEntity;
import com.example.mailcoreapi.service.MailService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MailController {
    private final Environment env;
    private final MailService mailService;

    public MailController(Environment environment, MailService mailService) {
        this.env = environment;
        this.mailService = mailService;
    }


    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Mail API is working: " + env.getProperty("local.server.port");
    }

    @PostMapping("/save")
    public MailEntity saveMail(@RequestBody MailEntity mail) {
        return mailService.saveMail(mail);
    }

    @GetMapping("/all")
    public List<MailEntityResponse> getAllMail() {
        return mailService.getAllMail();
    }

    @DeleteMapping
    public void deleteAllMail() {
        mailService.deleteAllMail();
    }
}