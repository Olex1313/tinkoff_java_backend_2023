package ru.edu.springliquibase.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.edu.springliquibase.model.entity.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookingRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Booking> rowMapper = new DataClassRowMapper<>(Booking.class);

    public Iterable<Booking> findAll() {
        return jdbcTemplate.query("select * from booking", rowMapper);
    }

    public List<Booking> findByRestaurantIdInPeriod(long restaurantId, LocalDateTime from, LocalDateTime to) {
        return jdbcTemplate.query(
            "select b.* from booking b where b.from >= :from and b.to <= :to and b.restaurant_id = :restaurantId",
            Map.of("from", from, "to", to, "restaurantId", restaurantId),
            rowMapper
        );
    }

    public Booking save(Booking booking) {
        return jdbcTemplate.queryForObject(
            "insert into booking(\"from\", \"to\", client_id, restaurant_id) values(:from, :to, :clientId, :restaurantId) returning *",
            new BeanPropertySqlParameterSource(booking),
            rowMapper
        );
    }

    public Optional<Booking> findById(Long bookingId) {
        return Optional.ofNullable(DataAccessUtils.singleResult(
            jdbcTemplate.query("select * from booking b where id = :id", Map.of("id", bookingId), rowMapper)
        ));
    }

    public List<Booking> findInOverlappingPeriod(LocalDateTime from, LocalDateTime to) {
        return jdbcTemplate.query(
            "select * from booking b where :from >= b.to or :to >= b.from",
            Map.of("from", from, "to", to),
            rowMapper
        );
    }

    public int updatePeriod(Long id, LocalDateTime from, LocalDateTime to) {
        return jdbcTemplate.update(
            "update booking b set \"from\" = :from, \"to\" = :to where b.id = :id",
            Map.of("id", id, "from", from, "to", to)
        );
    }

}
