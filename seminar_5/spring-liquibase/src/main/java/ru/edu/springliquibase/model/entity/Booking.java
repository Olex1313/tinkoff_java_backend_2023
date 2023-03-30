package ru.edu.springliquibase.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Booking {

    @Id
    private Long id;
    private LocalDateTime from;
    private LocalDateTime to;
    private Long clientId;
    private Long restaurantId;

}
