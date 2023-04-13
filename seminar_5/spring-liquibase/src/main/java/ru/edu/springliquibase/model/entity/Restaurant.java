package ru.edu.springliquibase.model.entity;

import lombok.Data;

import java.time.Instant;

@Data
public class Restaurant {

    private Long id;
    private String name;
    private String location;
    private Instant openTime;
    private Instant closeTime;

}
