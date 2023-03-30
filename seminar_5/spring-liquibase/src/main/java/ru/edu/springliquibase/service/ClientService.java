package ru.edu.springliquibase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.springliquibase.model.entity.Client;
import ru.edu.springliquibase.model.request.CreateClientRequest;
import ru.edu.springliquibase.repository.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(CreateClientRequest createClientRequest) {
        var client = new Client();
        client.setFirstName(createClientRequest.firstName());
        client.setMiddleName(createClientRequest.middleName());
        client.setLastName(createClientRequest.lastName());
        return clientRepository.save(client);
    }


    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(long clientId) {
        return clientRepository.findById(clientId);
    }

}
