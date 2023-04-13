package ru.edu.springliquibase.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Booking {

    private Long id;
    private LocalDateTime from;
    private LocalDateTime to;
    private Long clientId;
    private Long restaurantId;

}
