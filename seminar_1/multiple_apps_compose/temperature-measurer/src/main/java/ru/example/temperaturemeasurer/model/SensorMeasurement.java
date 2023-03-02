package ru.example.temperaturemeasurer.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.TimeSeries;

import java.time.Instant;

import static org.springframework.data.mongodb.core.timeseries.Granularity.SECONDS;

@Data
@RequiredArgsConstructor
@TimeSeries(collection = "temperature", timeField = "timestamp", metaField = "sensor", granularity = SECONDS)
public class SensorMeasurement {

    private final Instant timestamp;
    private final String sensor;
    private final Integer value;

    public static SensorMeasurement from(SensorResponse sensorResponse) {
        return new SensorMeasurement(
                Instant.now(),
                sensorResponse.sensorUuid(),
                sensorResponse.temperature()
        );
    }

}
