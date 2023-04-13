package ru.example.locks.model.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    @Nullable
    private String middleName;

    private long lockVersion;

}
