package com.example.mail;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MailService {
    private final Map<Long, Mail> mails = new HashMap<>();


    public Mail saveMail(Mail mail) {
        Long uuid = generateUUID();
        mail.setUuid(uuid);
        mails.put(uuid, mail);
        return mail;
    }

    private Long generateUUID() {
        return (long) (mails.size() + 1);
    }

    public Mail updateMail(Long uuid, Mail mail) {
        if (!mails.containsKey(uuid)) {
            throw new IllegalArgumentException("No such mail!");
        }
        mail.setUuid(uuid);
        mails.put(uuid, mail);
        return mail;
    }

    public Mail getMail(Long uuid) {
        return Optional.ofNullable(mails.get(uuid)).orElseThrow(() -> new IllegalArgumentException("No such mail!"));
    }

    public Collection<Mail> getAllMail() {
        return mails.values();
    }
}
