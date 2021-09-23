package com.example.paymentcoreapi.model;

public class ClientResponse {

    private String clientId;

    private String firstName;

    public ClientResponse() {
    }

    public ClientResponse(String clientId, String firstName) {
        this.clientId = clientId;
        this.firstName = firstName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
