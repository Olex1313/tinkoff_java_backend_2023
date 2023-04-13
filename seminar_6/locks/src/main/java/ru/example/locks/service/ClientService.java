package ru.example.locks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.locks.exception.NotFoundException;
import ru.example.locks.model.entity.Client;
import ru.example.locks.model.request.CreateClientRequest;
import ru.example.locks.model.request.UpdateClientRequest;
import ru.example.locks.repository.ClientRepository;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(CreateClientRequest createClientRequest) {
        var client = new Client();
        client.setFirstName(createClientRequest.firstName());
        client.setMiddleName(createClientRequest.middleName());
        client.setLastName(createClientRequest.lastName());
        client.setLockVersion(0);
        return clientRepository.save(client);
    }

    @Transactional
    public Client update(Long clientId, UpdateClientRequest updateClientRequest) {
        var existingClient = clientRepository.findById(clientId)
            .orElseThrow(() -> new NotFoundException(clientId, Client.class));
        if (updateClientRequest.firstName() != null) {
            existingClient.setFirstName(updateClientRequest.firstName());
        }
        if (updateClientRequest.middleName() != null) {
            existingClient.setMiddleName(updateClientRequest.middleName());
        }
        if (updateClientRequest.lastName() != null) {
            existingClient.setLastName(updateClientRequest.lastName());
        }
        boolean updated = clientRepository.update(existingClient) > 0;
        if (!updated) {
            throw new OptimisticLockingFailureException("Unable to update with id %d".formatted(clientId));
        }
        return existingClient;
    }


    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

}
