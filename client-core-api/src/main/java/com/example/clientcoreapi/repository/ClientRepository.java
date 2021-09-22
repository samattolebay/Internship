package com.example.clientcoreapi.repository;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    ClientEntity getClientEntityByClientId(String clientId);
}
