package ru.example.locks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.locks.model.entity.Client;
import ru.example.locks.model.request.CreateClientRequest;
import ru.example.locks.model.request.UpdateClientRequest;
import ru.example.locks.service.ClientService;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody CreateClientRequest createClientRequest) {
        return clientService.save(createClientRequest);
    }

    @PatchMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long clientId, @RequestBody UpdateClientRequest request) {
        return clientService.update(clientId, request);
    }

    @GetMapping
    public Iterable<Client> getClients() {
        return clientService.findAll();
    }

}
