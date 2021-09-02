package com.example.mail

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MailService {
    private var mails = mutableMapOf<Long, Mail>()

    fun saveMail(mail: Mail): Mail {
        val uuid = generateUUID()
        mail.uuid = uuid
        mails[uuid] = mail
        return mail
    }

    private fun generateUUID() = (mails.size + 1).toLong()

    fun getMail(uuid: Long): Mail {
        val mail = Optional.ofNullable(mails[uuid]).orElseThrow {
            throw IllegalArgumentException("No such mail!")
        }
        return mail
    }

    fun getAllMail() = mails.values.filter { mail -> !mail.delivered }

    fun saveAll(vararg args: Mail) {
        args.forEach { mail ->
            saveMail(mail)
        }
    }

    fun updateMail(uuid: Long, mail: Mail): Mail {
        if (!mails.containsKey(uuid)) {
            throw IllegalArgumentException("No such mail!")
        }
        mail.uuid = uuid
        mails[uuid] = mail
        return mail
    }
}

