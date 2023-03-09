package ru.example.featureswitcher.service;

import ru.example.featureswitcher.model.FeatureToggle;

import java.util.List;
import java.util.Optional;

public interface FeatureToggleService {

    FeatureToggle save(FeatureToggle featureToggle);

    Optional<FeatureToggle> findByName(String name);

    List<FeatureToggle> findAll();

    Optional<FeatureToggle> update(FeatureToggle featureToggle);

    void deleteByName(String name);

}
