package ru.edu.springliquibase.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateClientRequest(
    @JsonProperty("first_name")
    String firstName,
    @JsonProperty("last_name")
    String lastName,
    @JsonProperty("middle_name")
    String middleName
) {

}
