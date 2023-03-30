package ru.edu.springliquibase.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.edu.springliquibase.model.entity.Restaurant;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Restaurant> rowMapper = new DataClassRowMapper<>(Restaurant.class);

    public Iterable<Restaurant> findAll() {
        return jdbcTemplate.query("select * from restaurant", rowMapper);
    }

    public Optional<Restaurant> findById(long restaurantId) {
        return Optional.ofNullable(
            DataAccessUtils.singleResult(
                jdbcTemplate.query("select * from restaurant where id=:id", Map.of("id", restaurantId), rowMapper)
            )
        );
    }

}
