package com.example.mailcoreapi.model;

public class MailEntityResponse {

    private String name;
    private String sender;
    private String recipient;
    private String status;

    public MailEntityResponse(String name, String sender, String recipient, String status) {
        this.name = name;
        this.sender = sender;
        this.recipient = recipient;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
