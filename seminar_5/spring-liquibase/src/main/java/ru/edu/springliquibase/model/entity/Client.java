package ru.edu.springliquibase.model.entity;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    @Nullable
    private String middleName;

}
