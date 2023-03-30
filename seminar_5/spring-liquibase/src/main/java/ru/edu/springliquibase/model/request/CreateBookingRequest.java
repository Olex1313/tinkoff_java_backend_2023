package ru.edu.springliquibase.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;

public record CreateBookingRequest(
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime from,
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime to,
    @JsonProperty("restaurant_id")
    long restaurantId,
    @JsonProperty("client_id")
    long clientId
) {

}
