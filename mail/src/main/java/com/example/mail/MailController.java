package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/post")
public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public Mail saveMail(@RequestBody @Valid Mail mail) {
        return mailService.saveMail(mail);
    }

    @PutMapping("/{uuid}")
    public Mail updateMail(@PathVariable @Min(1) Long uuid, @RequestBody @Valid Mail mail) {
        return mailService.updateMail(uuid, mail);
    }

    @GetMapping("/{uuid}")
    public Mail getMail(@PathVariable @Min(1) Long uuid) {
        return mailService.getMail(uuid);
    }

    @GetMapping("/all")
    public Collection<Mail> getAllMail() {
        return mailService.getAllMail();
    }
}
