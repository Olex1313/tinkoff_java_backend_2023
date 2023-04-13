package ru.example.locks.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.example.locks.BaseIntegrationTest;
import ru.example.locks.model.entity.Client;
import ru.example.locks.model.request.CreateClientRequest;

public class ClientControllerTest extends BaseIntegrationTest {

    @Autowired
    private ClientController clientController;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createClient() {
        // given
        var createClientRequest = new CreateClientRequest("first", "last", "middle");
        var expectedClient = new Client();
        expectedClient.setLockVersion(0);
        expectedClient.setFirstName(createClientRequest.firstName());
        expectedClient.setMiddleName(createClientRequest.middleName());
        expectedClient.setLastName(createClientRequest.lastName());

        // when
        Client actualClient = clientController.createClient(createClientRequest);

        // then
        assertClientEqualsWithoutId(actualClient, expectedClient);
        assertClientSaved(actualClient);
    }

    private void assertClientSaved(Client actualClient) {
        Client saved = DataAccessUtils.singleResult(jdbcTemplate.query(
            "select * from client where id = ?",
            new DataClassRowMapper<>(Client.class),
            actualClient.getId()
        ));
        assertClientEqualsWithoutId(saved, actualClient);
    }

    private void assertClientEqualsWithoutId(Client actual, Client expected) {
        assertThat(actual)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expected);
    }

}
