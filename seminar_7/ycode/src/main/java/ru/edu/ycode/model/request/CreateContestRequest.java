package ru.edu.ycode.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateContestRequest(
    @JsonProperty("task_ids")
    List<Long> taskIds,

    @JsonProperty("student_ids")
    List<Long> studentIds
) {

}
