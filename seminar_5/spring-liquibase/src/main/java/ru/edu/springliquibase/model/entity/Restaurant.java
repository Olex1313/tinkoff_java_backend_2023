package ru.edu.springliquibase.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
public class Restaurant {

    @Id
    private Long id;
    private String name;
    private String location;
    private Instant openTime;
    private Instant closeTime;

}
