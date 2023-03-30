package ru.edu.springliquibase.model.entity;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Client {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Nullable
    private String middleName;

}
