package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientEntityRequest;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ClientEntity saveClient(ClientEntityRequest client) {
        ClientEntity clientEntity = new ClientEntity(UUID.randomUUID().toString(), client.getName());
        return clientRepository.save(clientEntity);
    }

    public List<ClientEntity> getAllClient() {
        return (List<ClientEntity>) clientRepository.findAll();
    }

    public ClientEntity getClient(String id) {
        return clientRepository.getClientEntityByClientId(id);
    }

    public void deleteAllClient() {
        clientRepository.deleteAll();
    }
}
