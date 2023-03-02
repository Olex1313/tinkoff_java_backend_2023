package ru.example.temperaturemeasurer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.example.temperaturemeasurer.model.SensorMeasurement;
import ru.example.temperaturemeasurer.service.SensorMeasurementService;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorMeasurementController {

    private final SensorMeasurementService sensorMeasurementService;

    @GetMapping
    public Flux<SensorMeasurement> getMeasurements() {
        return sensorMeasurementService.findAll();
    }
}
