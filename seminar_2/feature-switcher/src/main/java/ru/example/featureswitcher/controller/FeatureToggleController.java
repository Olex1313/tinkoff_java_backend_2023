package ru.example.featureswitcher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.featureswitcher.model.FeatureToggle;
import ru.example.featureswitcher.service.FeatureToggleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feature")
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
        return toggle.map(value -> new ResponseEntity<>(value, HttpStatusCode.valueOf(201)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<FeatureToggle> findAll() {
        return featureToggleService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<FeatureToggle> findByName(@RequestParam("name") String name) {
        var toggle = featureToggleService.findByName(name);
        return toggle.map(value -> new ResponseEntity<>(value, HttpStatusCode.valueOf(200)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestParam("name") String name) {
        if (featureToggleService.deleteByName(name)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }

}
