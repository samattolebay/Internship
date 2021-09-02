package com.example.mail

data class Mail(
    var uuid: Long?,
    var number: String,
    var destination: String,
    var delivered: Boolean = false
)
