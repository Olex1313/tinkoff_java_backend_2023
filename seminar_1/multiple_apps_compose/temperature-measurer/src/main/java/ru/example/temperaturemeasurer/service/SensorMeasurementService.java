package ru.example.temperaturemeasurer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.example.temperaturemeasurer.model.SensorMeasurement;
import ru.example.temperaturemeasurer.model.SensorMetadata;
import ru.example.temperaturemeasurer.model.SensorResponse;

import java.time.Duration;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorMeasurementService {

    private final WebClient webClient;
    private final ReactiveMongoTemplate mongoTemplate;
    private final Set<SensorMetadata> sensorMetadata;

    public Flux<SensorMeasurement> findAll() {
        return mongoTemplate.findAll(SensorMeasurement.class);
    }

    @Scheduled(fixedRate = 1000)
    public void gatherSensorsData() {
        log.info("Refreshing measurements for sensors {}", sensorMetadata);
        Flux.fromStream(sensorMetadata.stream())
                .flatMap(this::getSensorResponse)
                .map(SensorMeasurement::from)
                .flatMap(mongoTemplate::save)
                .blockLast();
        log.info("Refreshed sensors data");
    }

    private Mono<SensorResponse> getSensorResponse(SensorMetadata sensorMetadata) {
        log.info("Requesting metadata for sensor {}", sensorMetadata);
        return webClient.get()
                .uri(sensorMetadata.hostname() + "/temperature")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SensorResponse.class)
                .timeout(Duration.ofSeconds(1));
    }

}
