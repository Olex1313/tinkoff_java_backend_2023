package ru.example.locks.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.example.locks.model.entity.Client;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Client> rowMapper = new DataClassRowMapper<>(Client.class);

    public Client save(Client client) {
        return jdbcTemplate.queryForObject(
            "insert into client(first_name, last_name, middle_name, lock_version) values(:firstName, :lastName, :middleName, :lockVersion) returning *",
            new BeanPropertySqlParameterSource(client),
            rowMapper
        );
    }

    public Iterable<Client> findAll() {
        return jdbcTemplate.query("select * from client", rowMapper);
    }

    public Optional<Client> findById(long clientId) {
        return Optional.ofNullable(
            DataAccessUtils.singleResult(
                jdbcTemplate.query("select * from client where id=:id", Map.of("id", clientId), rowMapper)
            )
        );
    }

    public int update(Client existingClient) {
        return jdbcTemplate.update(
            """
                update client
                set 
                    first_name = :firstName, last_name = :lastName, 
                    middle_name = :middleName, lock_version = :lockVersion + 1
                where id = :id and lock_version = :lockVersion
                """,
            Map.of(
                "id", existingClient.getId(),
                "firstName", existingClient.getFirstName(),
                "lastName", existingClient.getLastName(),
                "middleName", existingClient.getMiddleName(),
                "lockVersion", existingClient.getLockVersion()
            )
        );
    }
}
