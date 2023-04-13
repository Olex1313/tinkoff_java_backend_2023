package ru.example.locks.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

public record UpdateClientRequest(
    @Nullable
    @JsonProperty("first_name")
    String firstName,
    @Nullable
    @JsonProperty("middle_name")
    String middleName,
    @Nullable
    @JsonProperty("last_name")
    String lastName
) {

}
