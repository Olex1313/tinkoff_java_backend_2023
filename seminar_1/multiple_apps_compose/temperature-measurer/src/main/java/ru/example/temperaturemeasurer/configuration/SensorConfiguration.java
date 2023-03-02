package ru.example.temperaturemeasurer.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.temperaturemeasurer.model.SensorMetadata;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class SensorConfiguration {

    @Bean
    public Set<SensorMetadata> sensorMetadata(@Value("${sensors}") String sensors) {
        return Arrays.stream(sensors.split(","))
                .map(String::trim)
                .map(SensorMetadata::new)
                .collect(Collectors.toSet());
    }

}
