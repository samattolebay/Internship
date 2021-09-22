package com.example.clientcoreapi.controller;

import com.example.clientcoreapi.model.ClientEntityRequest;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.service.ClientService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;
    private final Environment env;

    public ClientController(ClientService clientService, Environment env) {
        this.clientService = clientService;
        this.env = env;
    }

    @PostMapping("/save")
    public ClientEntity saveClient(@RequestBody ClientEntityRequest client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/all")
    public List<ClientEntity> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public ClientEntity getClient(@PathVariable String id) {
        return clientService.getClient(id);
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Client API is working: " + env.getProperty("local.server.port");
    }
}
