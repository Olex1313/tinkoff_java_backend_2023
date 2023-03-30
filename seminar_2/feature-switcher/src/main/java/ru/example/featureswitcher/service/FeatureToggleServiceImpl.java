package ru.example.featureswitcher.service;

import org.springframework.stereotype.Service;
import ru.example.featureswitcher.model.FeatureToggle;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class FeatureToggleServiceImpl implements FeatureToggleService {

    private final Map<String, FeatureToggle> inMemoryDb = new TreeMap<>();

    @Override
    public FeatureToggle save(FeatureToggle featureToggle) {
        inMemoryDb.put(featureToggle.getName(), featureToggle);
        return featureToggle;
    }

    @Override
    public Optional<FeatureToggle> findByName(String name) {
        return Optional.ofNullable(inMemoryDb.getOrDefault(name, null));
    }

    @Override
    public List<FeatureToggle> findAll() {
        return inMemoryDb.values().stream().toList();
    }

    @Override
    public Optional<FeatureToggle> update(FeatureToggle featureToggle) {
        if (!inMemoryDb.containsKey(featureToggle.getName())) {
            return Optional.empty();
        }
        return Optional.of(save(featureToggle));
    }

    @Override
    public boolean deleteByName(String name) {
        if (!inMemoryDb.containsKey(name)){
            return false;
        }
        inMemoryDb.remove(name);
        return true;
    }

}
