package com.example.mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class MailController(@Autowired var mailService: MailService) {

    @PostMapping
    fun saveMail(@RequestBody mail: Mail): Mail {
        return mailService.saveMail(mail)
    }

    @PutMapping("/{uuid}")
    fun updateMail(@PathVariable uuid: Long, @RequestBody mail: Mail): Mail {
        return mailService.updateMail(uuid, mail);
    }

    @GetMapping("/{uuid}")
    fun getMail(@PathVariable uuid: Long): Mail {
        return mailService.getMail(uuid)
    }

    @GetMapping("/all")
    fun getAllMail(): Collection<Mail> {
        return mailService.getAllMail()
    }
}