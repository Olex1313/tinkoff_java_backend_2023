package ru.example.featureswitcher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.example.featureswitcher.model.FeatureToggle;
import ru.example.featureswitcher.service.FeatureToggleService;

@RequiredArgsConstructor
@RestController("/api/feature")
public class FeatureToggleController {

    private final FeatureToggleService featureToggleService;


    @PostMapping("")
    public ResponseEntity<FeatureToggle> create(@RequestBody FeatureToggle featureToggle) {
        var toggle = featureToggleService.save(featureToggle);
        return new ResponseEntity<>(toggle, HttpStatusCode.valueOf(201));
    }

    @PutMapping("")
    public ResponseEntity<FeatureToggle> update(@RequestBody FeatureToggle featureToggle) {
        var toggle = featureToggleService.update(featureToggle);
        return new ResponseEntity<>(toggle.);
    }

}
