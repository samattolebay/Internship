package com.example.clientcoreapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientEntityRequest {
    @NotNull
    @NotBlank
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
