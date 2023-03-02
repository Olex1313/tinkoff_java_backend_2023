package ru.example.temperaturemeasurer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SensorResponse(int temperature, @JsonProperty("sensor_uuid") String sensorUuid) {
}
