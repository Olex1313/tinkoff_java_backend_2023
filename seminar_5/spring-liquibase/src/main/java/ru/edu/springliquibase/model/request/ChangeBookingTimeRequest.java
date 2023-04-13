package ru.edu.springliquibase.model.request;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;

public record ChangeBookingTimeRequest(
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime from,
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime to
) {

}
