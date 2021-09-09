package com.example.mail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Mail {
    private Long uuid;

    @NotNull(message="Name cannot be null")
    @Size(min = 2, max =16, message = "Name must be not less than two character")
    private String name;

    @NotNull(message = "Destination cannot be null")
    @NotBlank(message = "Destination cannot be blank")
    private String destination;

    private Boolean delivered;

    public Mail(Long uuid, String name, String destination, Boolean delivered) {
        this.uuid = uuid;
        this.name = name;
        this.destination = destination;
        this.delivered = delivered;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Mail() {
    }
}
