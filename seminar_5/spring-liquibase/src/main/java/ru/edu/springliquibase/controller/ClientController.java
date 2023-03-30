package ru.edu.springliquibase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.springliquibase.model.entity.Client;
import ru.edu.springliquibase.model.request.CreateClientRequest;
import ru.edu.springliquibase.service.ClientService;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody CreateClientRequest client) {
        return clientService.save(client);
    }

    @GetMapping
    public Iterable<Client> getClients() {
        return clientService.findAll();
    }

}
